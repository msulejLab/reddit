package pl.ppkwu.reddit.api;

import java.util.List;

/**
 * Strona danych z Reddita.
 * @param C Typ elementów na stronie, np. News
 */
public interface Page<C> {

	/**
	 * Niemutowalana lista elementów na stronie.
	 * @return Listę elementów na danej stronie.
	 */
	public List<C> content();

	/**
	 * @return Czy istnieje poprzednia strona względem strony reprezentowanej przez ten obiekt.
	 */
	public boolean hasPrevPage();

	/**
	 * @return Czy istnieje następna strona względem strony reprezentowanej przez ten obiekt.
	 */
	public boolean hasNextPage();

	/**
	 * Jeśli poprzednia strona istnieje uruchamia pobieranie poprzedniej strony i zwraca true.
	 * <br>Jeśli poprzednia strona nie istnieje zwraca false, callback nie jest wtedy uruchamiany.
	 * <br>Metoda asynchroniczna - nie czeka na zakończenie operacji.
	 * @param callback Callback uruchamiany po zakończeniu operacji pobierania poprzedniej strony.
	 * @return Czy istnieje poprzednia strona względem strony reprezentowanej przez ten obiekt.
	 * @throws NullPointerException Jeśli callback jest nullem. Nie rozpoczyna operacji.
	 * @see Page#hasPrevPage()
	 */
	public boolean loadPrevPage(Callback<Page<C>> callback) throws NullPointerException;

	/**
	 * Jeśli następna strona istnieje uruchamia pobieranie następnej strony i zwraca true.
	 * <br>Jeśli następna strona nie istnieje zwraca false, callback nie jest wtedy uruchamiany.
	 * <br>Metoda asynchroniczna - nie czeka na zakończenie operacji.
	 * @param callback Callback uruchamiany po zakończeniu operacji pobierania następnej strony.
	 * @return Czy istnieje następna strona względem strony reprezentowanej przez ten obiekt.
	 * @throws NullPointerException Jeśli callback jest nullem. Nie rozpoczyna operacji.
	 * @see Page#hasNextPage()
	 */
	public boolean loadNextPage(Callback<Page<C>> callback) throws NullPointerException;

}
