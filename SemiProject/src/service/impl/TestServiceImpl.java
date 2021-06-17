package service.impl;

import java.util.List;

import dto.Seoul;
import common.JDBCTemplate;
import dao.face.TestDao;
import dao.impl.TestDaoImpl;
import service.face.TestService;

public class TestServiceImpl implements TestService{
private TestDao testDao = new TestDaoImpl();
	@Override
	public List<Seoul> getList() {
		return testDao.selectList(JDBCTemplate.getConnection());
	}

}
