import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * Created by wuwei on 2016/10/11.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        Logger.init("TAG");
    }
}
