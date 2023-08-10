package com.leminhtien.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.leminhtien.dao.GenericDAO;
import com.leminhtien.mapper.RowMapper;
import com.leminhtien.utils.MyConnection;

public class AbstractDAO<T> implements GenericDAO<T> {

	@Override
	public <T> List<T> query(String sql, RowMapper<T> mapper, Object... parameters) {
		ArrayList<T> result = new ArrayList<>();
		PreparedStatement pre = null;
		Connection con = null;
		ResultSet resultSet = null;
		try {
			con = MyConnection.getConnection();
			pre = con.prepareStatement(sql);
			setParameter(pre, parameters);
			resultSet = pre.executeQuery();
			while (resultSet.next()) {
				result.add(mapper.add(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				if (pre != null) {
					pre.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	private void setParameter(PreparedStatement pre, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				int index = i + 1;
				Object item = parameters[i];
				if (item instanceof Integer) {
					pre.setInt(index, (Integer) item);
				} else if (item instanceof Float) {
					pre.setFloat(index, (Float) item);
				} else if (item instanceof String) {
					pre.setString(index, (String) item);
				} else if (item instanceof Timestamp) {
					pre.setTimestamp(index, (Timestamp) item);
				}else if(item == null) {
					System.out.println("it was run in set NULL");
					pre.setNull(index, Types.NULL);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public <T> T fineOne(String sql, RowMapper<T> mapper, Object... parameters) {
		Connection con = null;
		T model = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = MyConnection.getConnection();
			pre = con.prepareStatement(sql);
			setParameter(pre, parameters);
			resultSet = pre.executeQuery();
			if (resultSet.next()) {
				model = mapper.add(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				if (pre != null) {
					pre.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return model;

	}

	@Override
	public Integer insert(String sql, Object... parameters) {
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		Connection con = null;
		Integer id = null;
		try {
			con = MyConnection.getConnection();
			con.setAutoCommit(false);
			pre = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(pre, parameters);
			pre.executeUpdate();
			resultSet = pre.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			con.commit();
		} catch (SQLException e) {
			if (con != null) {
				try {
					con.rollback();
				} catch (Exception e2) {

				}
			}
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				if (pre != null) {
					pre.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return id;
	}

	@Override
	public Integer updateOrDelete(String sql, Object... parameters) {
		PreparedStatement pre = null;
		Connection con = null;
		Integer result = null;
		try {
			con = MyConnection.getConnection();
			con.setAutoCommit(false);
			pre = con.prepareStatement(sql);
			setParameter(pre, parameters);
			result = pre.executeUpdate();
			con.commit();
			return result;
		} catch (SQLException e) {
			if (con != null) {
				try {
					con.rollback();
				} catch (Exception e2) {

				}
			}
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pre != null) {
					pre.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	public Integer count(String sql) {
		PreparedStatement pre = null;
		Connection con = null;
		Integer result = null;
		ResultSet resultSet = null;
		try {
			con = MyConnection.getConnection();
			pre = con.prepareStatement(sql);
			resultSet = pre.executeQuery();
			if(resultSet.next()) {
				result = resultSet.getInt(1);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pre != null) {
					pre.close();
				}
				if(resultSet!=null) {
					resultSet.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<Integer> fineIds(String sql,String name,Object...parameters) {
		PreparedStatement pre = null;
		Connection con = null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		ResultSet resultSet = null;
		try {
			con = MyConnection.getConnection();
			pre = con.prepareStatement(sql);
			setParameter(pre, parameters);
			resultSet = pre.executeQuery();
			while(resultSet.next()) {
				result.add(resultSet.getInt(name));
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pre != null) {
					pre.close();
				}
				if(resultSet!=null) {
					resultSet.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}