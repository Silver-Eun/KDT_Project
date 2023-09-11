package j08_AbsInterface;
// ** 추상클래스 와 interface 의 활용
// => 일반적인 경우 사례
// => 실무에서는 interface가 많이 사용되고 (다중구현의 장점),
//    API 의 계층도에서는 추상클래스도 많이 이용됨

// ** 과제
// => 게시판을 종류별로 10개 이상 만든다고 가정
// => 기본 기능 (interface) : insert, update, delete, listPrint, detail, replyInsert
// => 게시판 종류별로 : 일반게시판(i, u, d, l, detail, r), QnA(i, r, l), 공지사항(i, l, detail)
// => 모든 게시판은 interface를 구현해야한다면
//    게시판 종류에 따라 필요없는 메소드도 오버라이딩 해야함
//    이런 경우 interface를 구현하는 추상 클래스를 작성하고
//    게시판은 이 추상클래스를 구현한다면 의무적 구현에서 벗어나 필요한 메소드만 구현 할 수 있음

interface Boardi {
	void insert();
	void update();
	void delete();
	void listPrint();
	void detail();
	void replyInsert();
}

// ** 추상클래스 : 일반메소드, 추상메소드
// => 추상 클래스는 추상메소드를 포함할 수 있으므로 오버라이딩 의무는 없음
// => 선택적으로 오버라이딩 가능
// => 의무구현 메소드(i,l)는 추상메소드로 두고, 선택적 구현메소드들은 미리 구현해놓음
// 그러므로 구현 클래스들의 의무구현 코드를 줄여줌
abstract class BoardA implements Boardi {
	@Override
	public void replyInsert() { }
	@Override
	public void delete() { }
	@Override
	public void update() { }
	@Override
	public void detail() { }
}

class MyBoard implements Boardi {
	public void insert() { System.out.println("** MyBoard Insert **"); }
	@Override
	public void listPrint() { System.out.println("** MyBoard List **");	}
	@Override
	public void replyInsert() { System.out.println("** MyBoard replyInsert **"); }
	@Override
	public void delete() { }
	@Override
	public void update() { }
	@Override
	public void detail() { }
}

//=> 추상 클래스를 상속 받도록 하여 의무를 줄여줌 
// class QnABoard implements BoardA {
class QnABoard extends BoardA {
	@Override
	public void insert() { System.out.println("** QnABoard Insert **"); }
	@Override
	public void listPrint() { System.out.println("** QnABoard List **"); }
	@Override
	public void replyInsert() { System.out.println("** QnABoard replyInsert **"); }
}

class NoticeBoard extends BoardA {
	@Override
	public void insert() { System.out.println("** NoticeBoard Insert **"); }
	@Override
	public void listPrint() { System.out.println("** NoticeBoard List **"); }
	@Override
	public void replyInsert() { System.out.println("** NoticeBoard replyInsert **"); }
}

public class Ex06_AbsInter {

	public static void main(String[] args) {
		Boardi bi = new QnABoard();
		// interface보다 적은 메소드 구현했지만,
		// interface의 모든 메소드를 오버라이딩한 추상클래스를 상속 받았음
		bi.update();
		bi.listPrint();
		
		BoardA ba = new QnABoard();
		// => BoardA을 상속받은 NoticeBoard와는 교체 가능
		// => BoardA을 상속받지 않은 MyBoard로는 생성할 수 없음
		ba.listPrint();
		ba.delete();
		// => QnABoard()에는 정의하지 않았지만, 조상인 BoardA에 있으므로 가능
		// => 그러나 BoardA에는 없고, QnABoard()에만 정의한 메소드가 있다면 사용 불가능
	}

}
