package co.sy.prj.member.serviceImpl;

import java.util.Scanner;

import co.sy.prj.comm.Command;
import co.sy.prj.member.service.MemberService;
import co.sy.prj.member.service.MemberVO;
import co.sy.prj.menu.Menu;

public class MemberSelect implements Command {
	private MemberService memberService = new MemberServiceImpl();
	private Scanner sc = new Scanner(System.in);

	@Override
	public void Execute() {
		// USER가 접근했을 때는 자기 정보만 그냥 나오도록. ID 입력하라는 말도 없이.
		//
		MemberVO member = new MemberVO();
		String res;

		System.out.println("[ MEMBER 조회 ] 를 진행하겠습니다.");
		if (!Menu.AUTHOR.equals("AUTHOR")) {
			member.setId(Menu.ID);
			member = memberService.memberSelect(member);
			System.out.println("- " + Menu.NAME + "님의 정보입니다.");
			System.out.println("ID       : " + member.getId());
			System.out.println("Name     : " + member.getName());
			System.out.println("Password : " + member.getPassword());
			System.out.println("Tel      : " + member.getTel());
			System.out.println("Addr     : " + member.getAddress());
			System.out.println("Author   : " + member.getAuthor());
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = =");
			return;
		}

		System.out.print("- 조회하고자 하는 MEMBER의 ID를 입력하세요 : ");
		String ID = sc.nextLine();
		res = memberService.memberName(ID);
		if (res == null) {
			System.out.println("[ ERROR ] : 존재하지 않는 ID 입니다.");
			return;
		}

		member.setId(ID);
		member = memberService.memberSelect(member);
		if (member != null) {
			System.out.println("- 검색하신 MEMBER에 대한 정보입니다.");
			System.out.println("ID       :  " + member.getId());
			System.out.println("Name     :  " + member.getName());
			System.out.println("Password :  " + member.getPassword());
			System.out.println("Tel      :  " + member.getTel());
			System.out.println("Addr     :  " + member.getAddress());
			System.out.println("Author   :  " + member.getAuthor());
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = =");
		} else {
			System.out.println("- 조회하신 MEMBER에 대한 정보를 찾을 수 없습니다.");
		}
	}
}
