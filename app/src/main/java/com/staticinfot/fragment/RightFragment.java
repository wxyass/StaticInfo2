package com.staticinfot.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.staticinfot.R;

public class RightFragment extends Fragment {
	private ImageView imageView;

	// 创建Fragment要展示的布局效果
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.right_fragment, null);
		imageView = (ImageView) view.findViewById(R.id.imageView);
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//先获取当前所在的Activity
		FragmentManager manager = getActivity().getSupportFragmentManager();
		LeftFragment leftFragment = (LeftFragment) manager.findFragmentById(R.id.left_fragment);
		//设置监听
		leftFragment.setOnGirlChangeListener(new OnGirlChangeListener() {
			//回调方法
			@Override
			public void setCurrentGirl(int resId) {
				//设置图片资源
				imageView.setImageResource(resId);
			}
		});
		
	}

}
