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

    private String pair;
    private String klineInterval;
    private long openTime;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal volume;
    private long closeTime;
    private BigDecimal quoteAssetVolume;
    private long numberOfTrades;
    private BigDecimal takerBuyBaseAssetVolume;
    private BigDecimal takerBuyQuoteAssetVolume;

    public BinanceCandlestick(){}

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

    public Integer getId() {
        return id;
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