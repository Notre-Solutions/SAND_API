package com.example.sand;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.knowm.xchange.binance.dto.marketdata.KlineInterval;
import org.knowm.xchange.currency.CurrencyPair;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

@Entity // This tells Hibernate to make a table out of this class
public class BinanceCandlestick {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private final String pair;
    private final String klineInterval;
    private final long openTime;
    private final BigDecimal open;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal close;
    private final BigDecimal volume;
    private final long closeTime;
    private final BigDecimal quoteAssetVolume;
    private final long numberOfTrades;
    private final BigDecimal takerBuyBaseAssetVolume;
    private final BigDecimal takerBuyQuoteAssetVolume;

    public BinanceCandlestick(
            String pair,
            String klineInterval,
            long openTime,
            BigDecimal open,
            BigDecimal high,
            BigDecimal low,
            BigDecimal close,
            BigDecimal volume,
            long closeTime,
            BigDecimal quoteAssetVolume,
            long numberOfTrades,
            BigDecimal takerBuyBaseAssetVolume,
            BigDecimal takerBuyQuoteAssetVolume
    ) {
        this.pair = pair;
        this.klineInterval = klineInterval;
        this.openTime = openTime;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.closeTime = closeTime;
        this.quoteAssetVolume = quoteAssetVolume;
        this.numberOfTrades = numberOfTrades;
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
    }

    public String getCurrencyPair() {
        return pair;
    }

    public String getKlineInterval() {
        return klineInterval;
    }

    public long getOpenTime() {
        return openTime;
    }

    public BigDecimal getOpenPrice() {
        return open;
    }

    public BigDecimal getHighPrice() {
        return high;
    }

    public BigDecimal getLowPrice() {
        return low;
    }

    public BigDecimal getAveragePrice() {
        return low.add(high).divide(new BigDecimal("2"));
    }

    public BigDecimal getClosePrice() {
        return close;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public long getCloseTime() {
        return closeTime;
    }

    public BigDecimal getQuoteAssetVolume() {
        return quoteAssetVolume;
    }

    public long getNumberOfTrades() {
        return numberOfTrades;
    }

    public BigDecimal getTakerBuyBaseAssetVolume() {
        return takerBuyBaseAssetVolume;
    }

    public BigDecimal getTakerBuyQuoteAssetVolume() {
        return takerBuyQuoteAssetVolume;
    }

    public String toString() {
        String tstamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(openTime);
        return String.format(
                "[%s] %s %s O:%.6f A:%.6f C:%.6f", pair, tstamp, klineInterval, open, getAveragePrice(), close);
    }
}