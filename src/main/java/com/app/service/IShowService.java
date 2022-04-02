package com.app.service;

import com.app.pojos.Show;

public interface IShowService {
	
	public Show addShow(Show show, int screenId, int theatreId, String movieId);
}
