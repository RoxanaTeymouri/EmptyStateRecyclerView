package com.roxa.emptystatehelper;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class Config {

    int loadingLayoutProgressBarRadius;
    int loadingLayoutProgressBarColor;
    int loadingLayoutProgressBarSpinWidth;

    int emptyLayoutImageWidth;
    int emptyLayoutImageHeight;
    int emptyLayoutTextSize;
    int emptyLayoutTextColor;
    String emptyLayoutMessage;
    Drawable emptyLayoutDrawable;

    int errorLayoutImageWidth;
    int errorLayoutImageHeight;
    int errorLayoutTextSize;
    int errorLayoutTextColor;
    int errorLayoutButtonTextSize;
    String errorLayoutMessage;
    String errorLayoutButtonText;
    Drawable errorLayoutDrawable;


    private Config() {
    }

    public static class Builder {
        private Config config = new Config();
        private Context context;

        public Builder(Context context) {
            this.context = context.getApplicationContext();
        }


        public Builder loadingLayoutProgressBarRadius(int loadingLayoutProgressBarRadius) {
            config.loadingLayoutProgressBarRadius = loadingLayoutProgressBarRadius;
            return this;
        }

        public Builder loadingLayoutProgressBarColor(int loadingLayoutProgressBarColor) {
            config.loadingLayoutProgressBarColor = loadingLayoutProgressBarColor;
            return this;
        }

        public Builder loadingLayoutProgressBarSpinWidth(int loadingLayoutProgressBarSpinWidth) {
            config.loadingLayoutProgressBarSpinWidth = loadingLayoutProgressBarSpinWidth;
            return this;
        }

        public Builder emptyLayoutImageWidth(int emptyLayoutImageWidth) {
            config.emptyLayoutImageWidth = emptyLayoutImageWidth;
            return this;
        }

        public Builder emptyLayoutImageHeight(int emptyLayoutImageHeight) {
            config.emptyLayoutImageHeight = emptyLayoutImageHeight;
            return this;
        }

        public Builder emptyLayoutTextSize(int emptyLayoutTextSize) {
            config.emptyLayoutTextSize = emptyLayoutTextSize;
            return this;
        }

        public Builder emptyLayoutTextColor(int emptyLayoutTextColor) {
            config.emptyLayoutTextColor = emptyLayoutTextColor;
            return this;
        }

        public Builder emptyLayoutMessage(String emptyLayoutMessage) {
            config.emptyLayoutMessage = emptyLayoutMessage;
            return this;
        }

        public Builder emptyLayoutDrawable(Drawable emptyLayoutDrawable) {
            config.emptyLayoutDrawable = emptyLayoutDrawable;
            return this;
        }


        public Builder errorLayoutImageWidth(int errorLayoutImageWidth) {
            config.errorLayoutImageWidth = errorLayoutImageWidth;
            return this;
        }

        public Builder errorLayoutImageHeight(int errorLayoutImageHeight) {
            config.errorLayoutImageHeight = errorLayoutImageHeight;
            return this;
        }

        public Builder errorLayoutTextSize(int errorLayoutTextSize) {
            config.errorLayoutTextSize = errorLayoutTextSize;
            return this;
        }


        public Builder errorLayoutTextColor(int errorLayoutTextColor) {
            config.errorLayoutTextColor = errorLayoutTextColor;
            return this;
        }

        public Builder errorLayoutButtonTextSize(int errorLayoutButtonTextSize) {
            config.errorLayoutButtonTextSize = errorLayoutButtonTextSize;
            return this;
        }


        public Builder errorLayoutButtonTextColor(int errorLayoutButtonTextColor) {
            config.errorLayoutTextColor = errorLayoutButtonTextColor;
            return this;
        }

        public Builder errorLayoutButtonText(String errorLayoutButtonText) {
            config.errorLayoutButtonText = errorLayoutButtonText;
            return this;
        }

        public Builder errorLayoutMessage(String errorLayoutMessage) {
            config.errorLayoutMessage = errorLayoutMessage;
            return this;
        }

        public Builder errorLayoutDrawable(Drawable errorLayoutDrawable) {
            config.errorLayoutDrawable = errorLayoutDrawable;
            return this;
        }

        public Config build() {
            return config;
        }
    }
}
