package com.re.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.re.dbutility.DBConnection;
import com.re.dto.Detail;


public class DetailsDAO {
	
	public static int addDetail(Detail detail){
		final String INSERT_QUERY="insert into details(user_id,city,location,budget,address,area,phasing,photo) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		//Detail detail = null;
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
					
					
			
			
			pst.setInt(1, detail.getUserId());
			System.out.println("------------"+detail.getUserId()+"--------------");
		    pst.setString(2, detail.getCity());
			pst.setString(3, detail.getLocation());
			pst.setDouble(4, detail.getBudget());
			pst.setString(5, detail.getAddress());
			pst.setString(6, detail.getArea());
			pst.setString(7, detail.getPhasing());
			pst.setString(8, detail.getPhoto());	
			
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
/*	public void insert(Date utilDate, String fileName) {
		PreparedStatement pst = null;
		Connection con = null;
		
		final String SQL_INSERT = "insert into person(updated_on,photo) values(?,?)";
		
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SQL_INSERT);
			pst.setDate(1, new java.sql.Date(utilDate.getTime()));
			pst.setString(2, fileName);			
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	*/
	
	/*public Detail showDetails(String city,String location){
		System.out.println(city);
		final String SELECT_QUERY="select register.Name,register.phno,details.city,details.location,details.budget,details.area,details.address,details.phasing from register INNER JOIN details ON register.user_id = details.user_id where city = ? and location = ?";
		PreparedStatement pst = null;
		ResultSet rst = null;
//		int status=0;
		Detail detail = null;

		try(Connection con = DBConnection.getConnection();){
			
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, city);
			pst.setString(2,location);
			rst = pst.executeQuery();
			if(rst.next()){
				 detail=new Detail();
				 detail.setUpdatedOn(rst.getString(4));
				 detail.setCity(city);
				 detail.setLocation(location);
				 detail.setAddress(rst.getString(6));
				 detail.setBudget(String.valueOf(rst.getDouble(5)));
				 //detail.setBalance(rst.getDouble(3));
				 detail.setPhasing(rst.getString(8));
				 detail.setArea(rst.getString(7));
			System.out.println(detail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		
		
		return detail;
	}
	*/
	public List<Detail> showDetails(String city, String Location){
		List<Detail> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
	final String SELECT_QUERY = "select register.Name,register.phno,details.city,details.location,details.budget,details.area,details.address,details.phasing,details.photo from register INNER JOIN details ON register.user_id = details.user_id where city = ? and location = ?";
	try(Connection con = DBConnection.getConnection();){
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, city);
		pst.setString(2, Location);
		rst = pst.executeQuery();
		while(rst.next()){
			Detail detail=new Detail();
			detail.setName(rst.getString(1));
			detail.setPhno(rst.getString(2));
			detail.setCity(rst.getString(3));
			detail.setLocation(rst.getString(4));
			detail.setBudget(rst.getDouble(5));
			detail.setArea(rst.getString(6));
			detail.setAddress(rst.getString(7));
			detail.setPhasing(rst.getString(8));
			detail.setPhoto(rst.getString(9));
			list.add(detail);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}
	
	public List<Detail> showCities(){
		List<Detail> City=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
	final String SELECT_QUERY = "select city from details";
	try(Connection con = DBConnection.getConnection();){
		pst = con.prepareStatement(SELECT_QUERY);
		
		rst = pst.executeQuery();
		while(rst.next()){
			Detail detail=new Detail();
			detail.setCity(rst.getString(1));
			
			City.add(detail);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return City;
	}
	
	
	/*public OrderBean getOrder(Integer fbOrderId) {

        OrderBean ob = new OrderBean();
        try {
            currentCon = ConnectionManager.getConnection();
            Statement statement = currentCon.createStatement();
            ResultSet rs = statement.executeQuery("SELECT fborders.fbMenuId, fbMenuName FROM fborders INNER JOIN fbmenu ON fborders.fbMenuId = fbmenu.fbMenuId WHERE fbOrderId='"+ fbOrderId + "'");

            while (rs.next()) {
                ob.setFbMenuId(rs.getString("fbMenuId"));
                ob.setFbMenuName(rs.getString("fbMenuName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ob;
    }*/



/*public ArrayList getCities() {
	PreparedStatement pst = null;
	ResultSet rst = null;
    ArrayList<Detail> cities= new ArrayList<Detail>();
   	final String SELECT_QUERY = "select  city from details";
	try(Connection con = DBConnection.getConnection();){
		pst = con.prepareStatement(SELECT_QUERY);
		//pst.setString(1, city);
		rst = pst.executeQuery();
        while (rst.next()) {
            Detail City = new Detail();
            City.setCity(rst.getString("cities"));
          //  ob.setFbMenuName(rs.getString("fbMenuName"));
            cities.add(City);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return cities;

}*/
	
}
