package br.com.lowestprice.view;

/**
 * Created by Gilson Maciel on 30/07/2015.
 */
public interface LoadDataView {
    /**
     * Show a view with a progress bar for a loading process
     */
    void showLoading();

    /**
     * Hide the loading bar
     */
    void hideLoading();

    /**
     * Display Error Message
     *
     * @param errorMessage
     */
    void showError(String errorMessage);

}
