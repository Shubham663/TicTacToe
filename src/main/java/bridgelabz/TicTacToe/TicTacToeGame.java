package bridgelabz.TicTacToe;

/**
 * Hello world!
 *
 */
public class TicTacToeGame 
{
	private char []arr = new char[10]; 
    /**
	 * @return the arr
	 */
	public char[] getArr() {
		return arr;
	}
	/**
	 * @param arr the arr to set
	 */
	public void setArr(char[] arr) {
		this.arr = arr;
	}
	
	/**
	 * @param arr
	 */
	public TicTacToeGame(char[] arr) {
		super();
		this.arr = arr;
	}
	public static void main( String[] args )
    {
        System.out.println( "Welcome to Tic Tac Toe game" );
    }
}
