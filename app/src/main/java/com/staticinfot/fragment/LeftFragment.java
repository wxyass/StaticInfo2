package com.staticinfot.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.staticinfot.R;

import java.util.ArrayList;


public class LeftFragment extends Fragment {
	private ListView listView;
	private ArrayList<String> dataList;
	// 放置图片的数组
	int[] resId = new int[] { R.drawable.a, R.drawable.a1, R.drawable.a2,
			R.drawable.a3, R.drawable.a4 };
	private OnGirlChangeListener changeListerer;

	// 创建Fragment要展示的布局效果
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.left_fragment, null);
		listView = (ListView) view.findViewById(R.id.listView);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		initData();
		// 设置数据适配器
		listView.setAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, dataList));
		// 添加条目点击事件
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
				// 触发监听方法
				changeListerer.setCurrentGirl(resId[position]);

			}
		});
	}

	private void initData() {
		dataList = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			dataList.add("第" + i + "美女");
		}
	}

	// 设置监听
	public void setOnGirlChangeListener(OnGirlChangeListener changeListener) {
		this.changeListerer = changeListener;
	}

//	// 定义监听器
//	public interface OnGirlChangeListener {
//		// 在监听中设置图片改变的方法
//		public void setCurrentGirl(int resId);
//	}
}
