package com.bumptech.glide.supportapp.github._670_delegate;

import java.io.*;

import android.content.Context;

import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.*;
import com.bumptech.glide.load.model.stream.StreamModelLoader;

class FlickrModelLoader implements StreamModelLoader<PhotoModel> {
	public FlickrModelLoader(Context context, ModelLoader<File, InputStream> loader) {
		this.loader = loader;
	}
	private final ModelLoader<File, InputStream> loader;

	@Override public DataFetcher<InputStream> getResourceFetcher(PhotoModel model, int width, int height) {
		return loader.getResourceFetcher(new File(model.getOriginalPath()), width, height);
	}

	public static class Factory implements ModelLoaderFactory<PhotoModel, InputStream> {
		@Override public ModelLoader<PhotoModel, InputStream> build(Context context, GenericLoaderFactory factories) {
			return new FlickrModelLoader(context, factories.buildModelLoader(File.class, InputStream.class));
		}

		@Override public void teardown() {
		}
	}
}
