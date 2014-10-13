package com.simon.synchronize;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class EventConsumer implements Runnable {
	private EventStorage storage;

	public EventConsumer(EventStorage storage) {
		this.storage = storage;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			storage.get();
			try {
				long value = new Random(new Date().getTime()).nextInt(10);
				TimeUnit.MILLISECONDS.sleep(value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
