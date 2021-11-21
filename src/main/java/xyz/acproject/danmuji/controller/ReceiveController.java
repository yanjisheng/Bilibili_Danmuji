package xyz.acproject.danmuji.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import xyz.acproject.danmuji.controller.param.ReceiveVO;
import xyz.acproject.danmuji.service.SendService;

@RestController
public class ReceiveController {
	
	@Autowired
	private SendService sendService;
	
	@PostMapping("/receive")
	public void receive(@RequestBody ReceiveVO vo) throws Exception {
		String message = vo.getMessage();
		if(message == null || message.length() == 0) {
			throw new RuntimeException("消息内容为空");
		}
		sendService.send(message);
	}

}
