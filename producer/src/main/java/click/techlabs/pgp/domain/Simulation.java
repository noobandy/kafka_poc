package click.techlabs.pgp.domain;

import java.util.Map;

public class Simulation {
		private String topic;
		private Map<Integer, MarketData> marketWiseData;
		
		public Simulation() {
			super();
			
		}

		public String getTopic() {
			return topic;
		}

		public void setTopic(String topic) {
			this.topic = topic;
		}

		public Map<Integer, MarketData> getMarketWiseData() {
			return marketWiseData;
		}

		public void setMarketWiseData(Map<Integer, MarketData> marketWiseData) {
			this.marketWiseData = marketWiseData;
		}

		@Override
		public String toString() {
			return "Simulation [topic=" + topic + ", marketWiseData=" + marketWiseData + "]";
		}
		
		
		
}
