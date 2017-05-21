/**
 * 
 */
package laffey.matthew;

/**
 * @author Matthew
 *
 */
public class Driver {

	public static void main(String[] args) {
		Deck d = new Deck();
		System.out.println(d);
		d.shuffle();
		System.out.println(d);
		System.out.println(d.drawACard());
		System.out.println(d);
		System.out.println(d.drawACard());
		System.out.println(d);
		System.out.println(d.drawACard());
		System.out.println(d);
	}

}
