package click.techlabs.pgp.domain;

import java.util.Map;

public class MarketData {

	private Long marketId;
	private Map<String, String> message;
	private int totalMessageCount = 1000;
	
	public MarketData() {
		super();
		
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public Map<String, String> getMessage() {
		return message;
	}

	public void setMessage(Map<String, String> message) {
		this.message = message;
	}

	

	public int getTotalMessageCount() {
		return totalMessageCount;
	}

	public void setTotalMessageCount(int totalMessageCount) {
		this.totalMessageCount = totalMessageCount;
	}

	
	
}
