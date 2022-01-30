package click.techlabs.pgp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class LoadSimulator<T> implements Runnable {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoadSimulator.class);

	private KafkaTemplate<String, T> template;
	private String topic;
	private String key;
	private T value;
	private int size;

	private ListenableFutureCallback<SendResult<String, T>> cb = new ListenableFutureCallback<SendResult<String, T>>() {

		@Override
		public void onSuccess(SendResult<String, T> result) {
			LOGGER.info("sent message {}", result.getRecordMetadata());
		}

		@Override
		public void onFailure(Throwable ex) {
			LOGGER.error("failed to send message", ex);

		}

	};

	public LoadSimulator(KafkaTemplate<String, T> template, String topic, String key, T value, int size) {
		super();
		this.template = template;
		this.topic = topic;
		this.key = key;
		this.value = value;
		this.size = size;
	}

	@Override
	public void run() {
		for (int i = 0; i < size; i++) {
			template.send(topic, key, value).addCallback(cb);
		}
	}

}
