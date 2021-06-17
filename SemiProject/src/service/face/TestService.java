package service.face;

import java.util.List;

import dto.Seoul;

public interface TestService {

	/**
	 * 서울 dto의 업소목록 가져온다
	 * @return List<Seoul>
	 */
	List<Seoul> getList();

}
