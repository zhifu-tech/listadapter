package com.zhi.widget.list.samples;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.View;

import com.zhi.widget.list.samples.util.Logs;

import java.lang.ref.WeakReference;

public class BaseFragment extends Fragment {

    public BaseFragment() {
        // EMPTY CONSTRUCTOR
    }

    /**
     * If this fragment does not have retain state, and have already set a view with
     * {@link #onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)}
     * this method is used to retrieve a specified child view.
     *
     * @return The view if found or null otherwise.
     * @see #onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     * @see #onViewCreated(android.view.View, android.os.Bundle)
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T findView(@IdRes int id) {
        if (getView() != null) {
            return (T) getView().findViewById(id);
        }
        return null;
    }

    /**
     * Small Runnable-like wrapper that first checks that the Fragment is in a good state before
     * doing any work. Ideal for use with a {@link android.os.Handler}.
     */
    public static abstract class FragmentRunnable implements Runnable {
        public static final String TAG = "FragmentRunnable";
        private final String mOpName;
        private final WeakReference<BaseFragment> mData;

        public FragmentRunnable(String opName, BaseFragment fragment) {
            mOpName = opName;
            mData = new WeakReference<>(fragment);
        }

        @Override
        public final void run() {
            final BaseFragment fragment = mData.get();
            if (fragment == null) {
                Logs.i(TAG, "Unable to run op='%s' b/c fragment has been recycled.", mOpName);
                return;
            }
            if (!fragment.isAdded()) {
                Logs.i(TAG, "Unable to run op='%s' b/c fragment is not attached: %s", mOpName, fragment);
                return;
            }
            go();
        }

        public abstract void go();
    }
}
