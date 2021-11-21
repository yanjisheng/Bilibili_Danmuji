package xyz.acproject.danmuji.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import xyz.acproject.danmuji.conf.PublicDataConf;

@Service
public class SendService {

	@Async
	public synchronized void send(String message) {
		if (PublicDataConf.sendBarrageThread != null
				&& !PublicDataConf.sendBarrageThread.FLAG) {
			PublicDataConf.barrageString.add(message);
			synchronized (PublicDataConf.sendBarrageThread) {
				PublicDataConf.sendBarrageThread.notify();
			}
		}
	}

}
