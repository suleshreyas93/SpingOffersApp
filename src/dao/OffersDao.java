package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("offersDao")
public class OffersDao {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc)
	{
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	//Get All offers
	public List<Offers> getAllOffers()
	{
		return jdbc.query("select * from offers", new RowMapper<Offers>(){

			@Override
			public Offers mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Offers offer = new Offers();
				
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				
				return offer;
				
			}
			
		});
	}

	/*public Offers getOfferById(Offers offer)
	{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.queryForObject("select * from offers where id = :id", params, new RowMapper<Offers>() {

			@Override
			public Offers mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Offers offer = new Offers();
				
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				
				return offer;
				
			}
		});
	}*/
}
