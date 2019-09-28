package cn.zhoufy.g.templatemethod;
/**
 * 1.template method: creating something when it needs by methond!
 *     Client-->abstrac class-->unimplemented method-->new implements class-->polymorship
 *     3.call:most part is stable,but something is variable. it's time to use call method by abstract method!
 * @author DELL
 *
 */
public class Client {
	public static void main(String[] args) {
		//EatMeeting em=new ChinaStyle();//directly New;
		EatMeeting em=new EatMeeting() {
			@Override
			void eatsomething() {
				System.out.println("eat west food!");
			}
		};
		
		
		em.bookHotel();
		em.eatsomething();
		em.payMoney();
		
	}

}
class ChinaStyle extends EatMeeting{

	@Override
	void eatsomething() {
		System.out.println("eat chian food!");
	}
	
}
