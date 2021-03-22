package com.mulcam.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mulcam.member.dao.MemberDAO;
import com.mulcam.member.vo.MemberVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public List listMembers() throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.selectAllMemberList();
	}

	@Override
	public int addMember(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.insertMember(memberVO);
	}

	@Override
	public int removeMember(String id) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.deleteMember(id);
	}

	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.loginById(memberVO);
	}

}
