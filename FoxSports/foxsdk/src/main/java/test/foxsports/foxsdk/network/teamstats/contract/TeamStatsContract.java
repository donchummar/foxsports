package test.foxsports.foxsdk.network.teamstats.contract;

import test.foxsports.foxsdk.network.contract.BaseInteractor;

/**
 * Created by don.chummar on 15/11/17.
 */
public interface TeamStatsContract {

    interface Presenter<T>{
        /**
         * on Success order
         */
        void onSuccessOrder(T result);

        /**
         * On failed update
         * @param call
         */
        void onFailedOrderUpdate(Object call);
    }

    interface Interactor extends BaseInteractor {
        /**
         * Call update order api
         */
        void getPlayerList(TeamStatsContract.Presenter presenter);
    }
}
