package com.roxa.emptystatehelper;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Roxan on 10/10/2018.
 */
public class EmptyStateRecyclerView extends FrameLayout {

    public Config config;
    private RecyclerView recyclerView;
    private FrameLayout contentFrame;
    private View emptyView;
    private View errorView;
    private View loadingView;

    private RecyclerView.AdapterDataObserver observer = new RecyclerView.AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            RecyclerView.Adapter<?> adapter = recyclerView.getAdapter();
            if (adapter != null && emptyView != null) {
                if (adapter.getItemCount() == 0) {
                    emptyView.setVisibility(View.VISIBLE);
                } else {
                    emptyView.setVisibility(View.GONE);
                }
            }
        }
    };

    public EmptyStateRecyclerView(Context context) {
        super(context);
        init(null);
    }

    public EmptyStateRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public EmptyStateRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.EmptyStateRecyclerView);
            try {

                config = new Config.Builder(getContext())
                        .emptyLayoutTextColor(typedArray.getColor(R.styleable.EmptyStateRecyclerView_emptyTextColor, getResources().getColor(R.color.grey)))
                        .emptyLayoutTextSize(typedArray.getDimensionPixelSize(R.styleable.EmptyStateRecyclerView_emptyTextSize, 0))
                        .emptyLayoutImageHeight(typedArray.getLayoutDimension(R.styleable.EmptyStateRecyclerView_emptyImageHeight, 0))
                        .emptyLayoutImageWidth(typedArray.getLayoutDimension(R.styleable.EmptyStateRecyclerView_errorImageWidth, 0))
                        .emptyLayoutMessage(typedArray.getString(R.styleable.EmptyStateRecyclerView_emptyMessage))
                        .emptyLayoutDrawable(typedArray.getDrawable(R.styleable.EmptyStateRecyclerView_emptyDrawable))
                        .errorLayoutButtonTextSize(typedArray.getDimensionPixelSize(R.styleable.EmptyStateRecyclerView_errorButtonTextSize, 0))
                        .errorLayoutButtonTextColor(typedArray.getColor(R.styleable.EmptyStateRecyclerView_errorButtonTextColor, getResources().getColor(R.color.grey)))
                        .errorLayoutImageHeight(typedArray.getDimensionPixelOffset(R.styleable.EmptyStateRecyclerView_errorImageHeight, 0))
                        .errorLayoutImageWidth(typedArray.getLayoutDimension(R.styleable.EmptyStateRecyclerView_errorImageWidth, 0))
                        .errorLayoutTextSize(typedArray.getDimensionPixelSize(R.styleable.EmptyStateRecyclerView_errorTextSize, 0))
                        .errorLayoutTextColor(typedArray.getColor(R.styleable.EmptyStateRecyclerView_errorTextColor, getResources().getColor(R.color.grey)))
                        .errorLayoutMessage(typedArray.getString(R.styleable.EmptyStateRecyclerView_errorMessage))
                        .errorLayoutButtonText(typedArray.getString(R.styleable.EmptyStateRecyclerView_errorButtonText))
                        .errorLayoutDrawable(typedArray.getDrawable(R.styleable.EmptyStateRecyclerView_errorDrawable))
                        .loadingLayoutProgressBarColor(typedArray.getColor(R.styleable.EmptyStateRecyclerView_loadingProgressBarColor, getResources().getColor(R.color.green)))
                        .loadingLayoutProgressBarRadius(typedArray.getLayoutDimension(R.styleable.EmptyStateRecyclerView_loadingProgressBarRadius, 0))
                        .loadingLayoutProgressBarSpinWidth(typedArray.getLayoutDimension(R.styleable.EmptyStateRecyclerView_loadingProgressBarSpinWidth, 0))
                        .build();

            } finally {
                typedArray.recycle();
            }
        }
        contentFrame = new FrameLayout(getContext());
        contentFrame.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        addView(contentFrame);

        emptyView = LayoutInflater.from(getContext()).inflate(R.layout.emptystatelayout, contentFrame, false);
        contentFrame.addView(emptyView);

        errorView = LayoutInflater.from(getContext()).inflate(R.layout.errorlayout, contentFrame, false);
        contentFrame.addView(errorView);

        loadingView = LayoutInflater.from(getContext()).inflate(R.layout.loadinglayout, contentFrame, false);
        contentFrame.addView(loadingView);

        recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        contentFrame.addView(recyclerView);
    }

    public void showLoading() {

        MaterialProgressWheel materialProgressWheel = loadingView.findViewById(R.id.progressBar);
        if (config.loadingLayoutProgressBarColor != 0) {
            materialProgressWheel.setBarColor(config.loadingLayoutProgressBarColor);
        }
        if (config.loadingLayoutProgressBarRadius != 0) {
            materialProgressWheel.setCircleRadius(config.loadingLayoutProgressBarRadius);
        }
        if (config.loadingLayoutProgressBarSpinWidth != 0) {
            materialProgressWheel.setBarWidth(config.loadingLayoutProgressBarSpinWidth);
        }
        loadingView.setVisibility(VISIBLE);
        emptyView.setVisibility(GONE);
        errorView.setVisibility(GONE);

    }

    public void showError() {

        ImageView errorImageView = errorView.findViewById(R.id.errorStateImageView);
        if (config.errorLayoutDrawable != null) {
            errorImageView.setImageDrawable(config.errorLayoutDrawable);
        }
        if (config.errorLayoutImageWidth != 0) {
            errorImageView.getLayoutParams().width = config.errorLayoutImageWidth;
        }
        if (config.emptyLayoutImageHeight != 0) {
            errorImageView.getLayoutParams().height = config.emptyLayoutImageHeight;
        }

        TextView errorTextView = errorView.findViewById(R.id.errorStateContentTextView);
        if (config.errorLayoutMessage != null) {
            errorTextView.setText(config.errorLayoutMessage);
        }
        if (config.errorLayoutTextColor != 0) {
            errorTextView.setTextColor(config.errorLayoutTextColor);
        }
        if (config.errorLayoutTextSize != 0) {
            errorTextView.setTextSize(config.errorLayoutTextSize);
        }

        Button errorButton = errorView.findViewById(R.id.errorStateButton);
        if (config.errorLayoutButtonText != null) {
            errorButton.setText(config.errorLayoutButtonText);
        }
        if (config.errorLayoutTextSize != 0) {
            errorButton.setTextColor(config.errorLayoutTextSize);
        }
        if (config.errorLayoutButtonTextSize != 0) {
            errorButton.setTextSize(config.errorLayoutButtonTextSize);
        }

        errorView.setVisibility(VISIBLE);
        emptyView.setVisibility(GONE);
        loadingView.setVisibility(GONE);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter.getItemCount() == 0) {

            ImageView emptyImageView = emptyView.findViewById(R.id.emptyStateImageView);
            if (config.emptyLayoutImageWidth != 0) {
                emptyImageView.getLayoutParams().width = config.emptyLayoutImageWidth;
            }
            if (config.emptyLayoutImageHeight != 0) {
                emptyImageView.getLayoutParams().height = config.emptyLayoutImageHeight;
            }
            if (config.emptyLayoutDrawable != null) {
                emptyImageView.setImageDrawable(config.emptyLayoutDrawable);
            }

            TextView emptyTextView = emptyView.findViewById(R.id.emptyStateTextView);
            if (config.emptyLayoutTextColor != 0) {
                emptyTextView.setTextColor(config.emptyLayoutTextColor);
            }
            if (config.emptyLayoutTextSize != 0) {
                emptyTextView.setTextSize(config.emptyLayoutTextSize);
            }

            if (config.emptyLayoutMessage != null) {
                emptyTextView.setText(config.emptyLayoutMessage);
            }
            emptyView.setVisibility(VISIBLE);
        }
        adapter.registerAdapterDataObserver(observer);

        recyclerView.setLayoutManager(new

                LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

//    private void setUpLoadingView() {
//
//        View loadingView = LayoutInflater.from(getContext()).inflate(R.layout.loadinglayout, this);
//        MaterialProgressWheel materialProgressWheel = loadingView.findViewById(R.id.progressBar);
//
//        materialProgressWheel.setBarColor(config.loadingLayoutProgressBarColor);
//        materialProgressWheel.setCircleRadius(config.loadingLayoutProgressBarRadius);
//        materialProgressWheel.setBarWidth(config.loadingLayoutProgressBarSpinWidth);
//        addView(loadingView);
//
//    }

//    private void setUpEmptyView(Drawable imageEmpty, String emptyError) {
//
//        View emptyView = LayoutInflater.from(getContext()).inflate(R.layout.emptystatelayout, this);
//        ImageView emptyImageView = emptyView.findViewById(R.id.emptyStateImageView);
//        emptyImageView.getLayoutParams().width = config.emptyLayoutImageWidth;
//        emptyImageView.getLayoutParams().height = config.emptyLayoutImageHeight;
//        emptyImageView.setImageDrawable(imageEmpty);
//
//        TextView emptyTextView = emptyView.findViewById(R.id.emptyStateTextView);
//        emptyTextView.setTextColor(config.emptyLayoutTextColor);
//        emptyTextView.setTextSize(config.emptyLayoutTextSize);
//        emptyTextView.setText(emptyError);
//
//        addView(emptyView);
//
//    }
//
//    private void setUpErrorView(Drawable imageError, String errorText, String buttonText) {
//
//        View errorView = LayoutInflater.from(getContext()).inflate(R.layout.errorlayout, this);
//        ImageView errorImageView = errorView.findViewById(R.id.errorStateImageView);
//        errorImageView.getLayoutParams().width = config.errorLayoutImageWidth;
//        errorImageView.getLayoutParams().height = config.errorLayoutImageHeight;
//        errorImageView.setImageDrawable(imageError);
//
//        TextView errorTextView = errorView.findViewById(R.id.errorStateContentTextView);
//        errorTextView.setTextSize(config.errorLayoutTextSize);
//        errorTextView.setTextColor(config.errorLayoutTextColor);
//        errorTextView.setText(errorText);
//
//        Button errorButton = errorView.findViewById(R.id.errorStateButton);
//        errorButton.setTextSize(config.errorLayoutButtonTextSize);
//        errorButton.setText(buttonText);
//
//        addView(errorView);
//    }


}
