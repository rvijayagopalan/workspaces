
package com.tranzmind.wealth.finance.stock.entity;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxAge",
    "priceHint",
    "enterpriseValue",
    "forwardPE",
    "profitMargins",
    "floatShares",
    "sharesOutstanding",
    "sharesShort",
    "sharesShortPriorMonth",
    "sharesShortPreviousMonthDate",
    "dateShortInterest",
    "sharesPercentSharesOut",
    "heldPercentInsiders",
    "heldPercentInstitutions",
    "shortRatio",
    "shortPercentOfFloat",
    "beta",
    "morningStarOverallRating",
    "morningStarRiskRating",
    "category",
    "bookValue",
    "priceToBook",
    "annualReportExpenseRatio",
    "ytdReturn",
    "beta3Year",
    "totalAssets",
    "yield",
    "fundFamily",
    "fundInceptionDate",
    "legalType",
    "threeYearAverageReturn",
    "fiveYearAverageReturn",
    "priceToSalesTrailing12Months",
    "lastFiscalYearEnd",
    "nextFiscalYearEnd",
    "mostRecentQuarter",
    "earningsQuarterlyGrowth",
    "revenueQuarterlyGrowth",
    "netIncomeToCommon",
    "trailingEps",
    "forwardEps",
    "pegRatio",
    "lastSplitFactor",
    "lastSplitDate",
    "enterpriseToRevenue",
    "enterpriseToEbitda",
    "52WeekChange",
    "SandP52WeekChange",
    "lastDividendValue",
    "lastCapGain",
    "annualHoldingsTurnover"
})
public class DefaultKeyStatistics {

    @JsonProperty("maxAge")
    private Integer maxAge;
    @JsonProperty("priceHint")
    private PriceHint priceHint;
    @JsonProperty("enterpriseValue")
    private EnterpriseValue enterpriseValue;
    @JsonProperty("forwardPE")
    private ForwardPE forwardPE;
    @JsonProperty("profitMargins")
    private ProfitMargins profitMargins;
    @JsonProperty("floatShares")
    private FloatShares floatShares;
    @JsonProperty("sharesOutstanding")
    private SharesOutstanding sharesOutstanding;
    @JsonProperty("sharesShort")
    private SharesShort sharesShort;
    @JsonProperty("sharesShortPriorMonth")
    private SharesShortPriorMonth sharesShortPriorMonth;
    @JsonProperty("sharesShortPreviousMonthDate")
    private SharesShortPreviousMonthDate sharesShortPreviousMonthDate;
    @JsonProperty("dateShortInterest")
    private DateShortInterest dateShortInterest;
    @JsonProperty("sharesPercentSharesOut")
    private SharesPercentSharesOut sharesPercentSharesOut;
    @JsonProperty("heldPercentInsiders")
    private HeldPercentInsiders heldPercentInsiders;
    @JsonProperty("heldPercentInstitutions")
    private HeldPercentInstitutions heldPercentInstitutions;
    @JsonProperty("shortRatio")
    private ShortRatio shortRatio;
    @JsonProperty("shortPercentOfFloat")
    private ShortPercentOfFloat shortPercentOfFloat;
    @JsonProperty("beta")
    private Beta beta;
    @JsonProperty("morningStarOverallRating")
    private MorningStarOverallRating morningStarOverallRating;
    @JsonProperty("morningStarRiskRating")
    private MorningStarRiskRating morningStarRiskRating;
    @JsonProperty("category")
    private Object category;
    @JsonProperty("bookValue")
    private BookValue bookValue;
    @JsonProperty("priceToBook")
    private PriceToBook priceToBook;
    @JsonProperty("annualReportExpenseRatio")
    private AnnualReportExpenseRatio annualReportExpenseRatio;
    @JsonProperty("ytdReturn")
    private YtdReturn ytdReturn;
    @JsonProperty("beta3Year")
    private Beta3Year beta3Year;
    @JsonProperty("totalAssets")
    private TotalAssets totalAssets;
    @JsonProperty("yield")
    private Yield yield;
    @JsonProperty("fundFamily")
    private Object fundFamily;
    @JsonProperty("fundInceptionDate")
    private FundInceptionDate fundInceptionDate;
    @JsonProperty("legalType")
    private Object legalType;
    @JsonProperty("threeYearAverageReturn")
    private ThreeYearAverageReturn threeYearAverageReturn;
    @JsonProperty("fiveYearAverageReturn")
    private FiveYearAverageReturn fiveYearAverageReturn;
    @JsonProperty("priceToSalesTrailing12Months")
    private PriceToSalesTrailing12Months priceToSalesTrailing12Months;
    @JsonProperty("lastFiscalYearEnd")
    private LastFiscalYearEnd lastFiscalYearEnd;
    @JsonProperty("nextFiscalYearEnd")
    private NextFiscalYearEnd nextFiscalYearEnd;
    @JsonProperty("mostRecentQuarter")
    private MostRecentQuarter mostRecentQuarter;
    @JsonProperty("earningsQuarterlyGrowth")
    private EarningsQuarterlyGrowth earningsQuarterlyGrowth;
    @JsonProperty("revenueQuarterlyGrowth")
    private RevenueQuarterlyGrowth revenueQuarterlyGrowth;
    @JsonProperty("netIncomeToCommon")
    private NetIncomeToCommon netIncomeToCommon;
    @JsonProperty("trailingEps")
    private TrailingEps trailingEps;
    @JsonProperty("forwardEps")
    private ForwardEps forwardEps;
    @JsonProperty("pegRatio")
    private PegRatio pegRatio;
    @JsonProperty("lastSplitFactor")
    private String lastSplitFactor;
    @JsonProperty("lastSplitDate")
    private LastSplitDate lastSplitDate;
    @JsonProperty("enterpriseToRevenue")
    private EnterpriseToRevenue enterpriseToRevenue;
    @JsonProperty("enterpriseToEbitda")
    private EnterpriseToEbitda enterpriseToEbitda;
    @JsonProperty("52WeekChange")
    private com.tranzmind.wealth.finance.stock.entity._52WeekChange _52WeekChange;
    @JsonProperty("SandP52WeekChange")
    private SandP52WeekChange sandP52WeekChange;
    @JsonProperty("lastDividendValue")
    private LastDividendValue lastDividendValue;
    @JsonProperty("lastCapGain")
    private LastCapGain lastCapGain;
    @JsonProperty("annualHoldingsTurnover")
    private AnnualHoldingsTurnover annualHoldingsTurnover;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("maxAge")
    public Integer getMaxAge() {
        return maxAge;
    }

    @JsonProperty("maxAge")
    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    @JsonProperty("priceHint")
    public PriceHint getPriceHint() {
        return priceHint;
    }

    @JsonProperty("priceHint")
    public void setPriceHint(PriceHint priceHint) {
        this.priceHint = priceHint;
    }

    @JsonProperty("enterpriseValue")
    public EnterpriseValue getEnterpriseValue() {
        return enterpriseValue;
    }

    @JsonProperty("enterpriseValue")
    public void setEnterpriseValue(EnterpriseValue enterpriseValue) {
        this.enterpriseValue = enterpriseValue;
    }

    @JsonProperty("forwardPE")
    public ForwardPE getForwardPE() {
        return forwardPE;
    }

    @JsonProperty("forwardPE")
    public void setForwardPE(ForwardPE forwardPE) {
        this.forwardPE = forwardPE;
    }

    @JsonProperty("profitMargins")
    public ProfitMargins getProfitMargins() {
        return profitMargins;
    }

    @JsonProperty("profitMargins")
    public void setProfitMargins(ProfitMargins profitMargins) {
        this.profitMargins = profitMargins;
    }

    @JsonProperty("floatShares")
    public FloatShares getFloatShares() {
        return floatShares;
    }

    @JsonProperty("floatShares")
    public void setFloatShares(FloatShares floatShares) {
        this.floatShares = floatShares;
    }

    @JsonProperty("sharesOutstanding")
    public SharesOutstanding getSharesOutstanding() {
        return sharesOutstanding;
    }

    @JsonProperty("sharesOutstanding")
    public void setSharesOutstanding(SharesOutstanding sharesOutstanding) {
        this.sharesOutstanding = sharesOutstanding;
    }

    @JsonProperty("sharesShort")
    public SharesShort getSharesShort() {
        return sharesShort;
    }

    @JsonProperty("sharesShort")
    public void setSharesShort(SharesShort sharesShort) {
        this.sharesShort = sharesShort;
    }

    @JsonProperty("sharesShortPriorMonth")
    public SharesShortPriorMonth getSharesShortPriorMonth() {
        return sharesShortPriorMonth;
    }

    @JsonProperty("sharesShortPriorMonth")
    public void setSharesShortPriorMonth(SharesShortPriorMonth sharesShortPriorMonth) {
        this.sharesShortPriorMonth = sharesShortPriorMonth;
    }

    @JsonProperty("sharesShortPreviousMonthDate")
    public SharesShortPreviousMonthDate getSharesShortPreviousMonthDate() {
        return sharesShortPreviousMonthDate;
    }

    @JsonProperty("sharesShortPreviousMonthDate")
    public void setSharesShortPreviousMonthDate(SharesShortPreviousMonthDate sharesShortPreviousMonthDate) {
        this.sharesShortPreviousMonthDate = sharesShortPreviousMonthDate;
    }

    @JsonProperty("dateShortInterest")
    public DateShortInterest getDateShortInterest() {
        return dateShortInterest;
    }

    @JsonProperty("dateShortInterest")
    public void setDateShortInterest(DateShortInterest dateShortInterest) {
        this.dateShortInterest = dateShortInterest;
    }

    @JsonProperty("sharesPercentSharesOut")
    public SharesPercentSharesOut getSharesPercentSharesOut() {
        return sharesPercentSharesOut;
    }

    @JsonProperty("sharesPercentSharesOut")
    public void setSharesPercentSharesOut(SharesPercentSharesOut sharesPercentSharesOut) {
        this.sharesPercentSharesOut = sharesPercentSharesOut;
    }

    @JsonProperty("heldPercentInsiders")
    public HeldPercentInsiders getHeldPercentInsiders() {
        return heldPercentInsiders;
    }

    @JsonProperty("heldPercentInsiders")
    public void setHeldPercentInsiders(HeldPercentInsiders heldPercentInsiders) {
        this.heldPercentInsiders = heldPercentInsiders;
    }

    @JsonProperty("heldPercentInstitutions")
    public HeldPercentInstitutions getHeldPercentInstitutions() {
        return heldPercentInstitutions;
    }

    @JsonProperty("heldPercentInstitutions")
    public void setHeldPercentInstitutions(HeldPercentInstitutions heldPercentInstitutions) {
        this.heldPercentInstitutions = heldPercentInstitutions;
    }

    @JsonProperty("shortRatio")
    public ShortRatio getShortRatio() {
        return shortRatio;
    }

    @JsonProperty("shortRatio")
    public void setShortRatio(ShortRatio shortRatio) {
        this.shortRatio = shortRatio;
    }

    @JsonProperty("shortPercentOfFloat")
    public ShortPercentOfFloat getShortPercentOfFloat() {
        return shortPercentOfFloat;
    }

    @JsonProperty("shortPercentOfFloat")
    public void setShortPercentOfFloat(ShortPercentOfFloat shortPercentOfFloat) {
        this.shortPercentOfFloat = shortPercentOfFloat;
    }

    @JsonProperty("beta")
    public Beta getBeta() {
        return beta;
    }

    @JsonProperty("beta")
    public void setBeta(Beta beta) {
        this.beta = beta;
    }

    @JsonProperty("morningStarOverallRating")
    public MorningStarOverallRating getMorningStarOverallRating() {
        return morningStarOverallRating;
    }

    @JsonProperty("morningStarOverallRating")
    public void setMorningStarOverallRating(MorningStarOverallRating morningStarOverallRating) {
        this.morningStarOverallRating = morningStarOverallRating;
    }

    @JsonProperty("morningStarRiskRating")
    public MorningStarRiskRating getMorningStarRiskRating() {
        return morningStarRiskRating;
    }

    @JsonProperty("morningStarRiskRating")
    public void setMorningStarRiskRating(MorningStarRiskRating morningStarRiskRating) {
        this.morningStarRiskRating = morningStarRiskRating;
    }

    @JsonProperty("category")
    public Object getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Object category) {
        this.category = category;
    }

    @JsonProperty("bookValue")
    public BookValue getBookValue() {
        return bookValue;
    }

    @JsonProperty("bookValue")
    public void setBookValue(BookValue bookValue) {
        this.bookValue = bookValue;
    }

    @JsonProperty("priceToBook")
    public PriceToBook getPriceToBook() {
        return priceToBook;
    }

    @JsonProperty("priceToBook")
    public void setPriceToBook(PriceToBook priceToBook) {
        this.priceToBook = priceToBook;
    }

    @JsonProperty("annualReportExpenseRatio")
    public AnnualReportExpenseRatio getAnnualReportExpenseRatio() {
        return annualReportExpenseRatio;
    }

    @JsonProperty("annualReportExpenseRatio")
    public void setAnnualReportExpenseRatio(AnnualReportExpenseRatio annualReportExpenseRatio) {
        this.annualReportExpenseRatio = annualReportExpenseRatio;
    }

    @JsonProperty("ytdReturn")
    public YtdReturn getYtdReturn() {
        return ytdReturn;
    }

    @JsonProperty("ytdReturn")
    public void setYtdReturn(YtdReturn ytdReturn) {
        this.ytdReturn = ytdReturn;
    }

    @JsonProperty("beta3Year")
    public Beta3Year getBeta3Year() {
        return beta3Year;
    }

    @JsonProperty("beta3Year")
    public void setBeta3Year(Beta3Year beta3Year) {
        this.beta3Year = beta3Year;
    }

    @JsonProperty("totalAssets")
    public TotalAssets getTotalAssets() {
        return totalAssets;
    }

    @JsonProperty("totalAssets")
    public void setTotalAssets(TotalAssets totalAssets) {
        this.totalAssets = totalAssets;
    }

    @JsonProperty("yield")
    public Yield getYield() {
        return yield;
    }

    @JsonProperty("yield")
    public void setYield(Yield yield) {
        this.yield = yield;
    }

    @JsonProperty("fundFamily")
    public Object getFundFamily() {
        return fundFamily;
    }

    @JsonProperty("fundFamily")
    public void setFundFamily(Object fundFamily) {
        this.fundFamily = fundFamily;
    }

    @JsonProperty("fundInceptionDate")
    public FundInceptionDate getFundInceptionDate() {
        return fundInceptionDate;
    }

    @JsonProperty("fundInceptionDate")
    public void setFundInceptionDate(FundInceptionDate fundInceptionDate) {
        this.fundInceptionDate = fundInceptionDate;
    }

    @JsonProperty("legalType")
    public Object getLegalType() {
        return legalType;
    }

    @JsonProperty("legalType")
    public void setLegalType(Object legalType) {
        this.legalType = legalType;
    }

    @JsonProperty("threeYearAverageReturn")
    public ThreeYearAverageReturn getThreeYearAverageReturn() {
        return threeYearAverageReturn;
    }

    @JsonProperty("threeYearAverageReturn")
    public void setThreeYearAverageReturn(ThreeYearAverageReturn threeYearAverageReturn) {
        this.threeYearAverageReturn = threeYearAverageReturn;
    }

    @JsonProperty("fiveYearAverageReturn")
    public FiveYearAverageReturn getFiveYearAverageReturn() {
        return fiveYearAverageReturn;
    }

    @JsonProperty("fiveYearAverageReturn")
    public void setFiveYearAverageReturn(FiveYearAverageReturn fiveYearAverageReturn) {
        this.fiveYearAverageReturn = fiveYearAverageReturn;
    }

    @JsonProperty("priceToSalesTrailing12Months")
    public PriceToSalesTrailing12Months getPriceToSalesTrailing12Months() {
        return priceToSalesTrailing12Months;
    }

    @JsonProperty("priceToSalesTrailing12Months")
    public void setPriceToSalesTrailing12Months(PriceToSalesTrailing12Months priceToSalesTrailing12Months) {
        this.priceToSalesTrailing12Months = priceToSalesTrailing12Months;
    }

    @JsonProperty("lastFiscalYearEnd")
    public LastFiscalYearEnd getLastFiscalYearEnd() {
        return lastFiscalYearEnd;
    }

    @JsonProperty("lastFiscalYearEnd")
    public void setLastFiscalYearEnd(LastFiscalYearEnd lastFiscalYearEnd) {
        this.lastFiscalYearEnd = lastFiscalYearEnd;
    }

    @JsonProperty("nextFiscalYearEnd")
    public NextFiscalYearEnd getNextFiscalYearEnd() {
        return nextFiscalYearEnd;
    }

    @JsonProperty("nextFiscalYearEnd")
    public void setNextFiscalYearEnd(NextFiscalYearEnd nextFiscalYearEnd) {
        this.nextFiscalYearEnd = nextFiscalYearEnd;
    }

    @JsonProperty("mostRecentQuarter")
    public MostRecentQuarter getMostRecentQuarter() {
        return mostRecentQuarter;
    }

    @JsonProperty("mostRecentQuarter")
    public void setMostRecentQuarter(MostRecentQuarter mostRecentQuarter) {
        this.mostRecentQuarter = mostRecentQuarter;
    }

    @JsonProperty("earningsQuarterlyGrowth")
    public EarningsQuarterlyGrowth getEarningsQuarterlyGrowth() {
        return earningsQuarterlyGrowth;
    }

    @JsonProperty("earningsQuarterlyGrowth")
    public void setEarningsQuarterlyGrowth(EarningsQuarterlyGrowth earningsQuarterlyGrowth) {
        this.earningsQuarterlyGrowth = earningsQuarterlyGrowth;
    }

    @JsonProperty("revenueQuarterlyGrowth")
    public RevenueQuarterlyGrowth getRevenueQuarterlyGrowth() {
        return revenueQuarterlyGrowth;
    }

    @JsonProperty("revenueQuarterlyGrowth")
    public void setRevenueQuarterlyGrowth(RevenueQuarterlyGrowth revenueQuarterlyGrowth) {
        this.revenueQuarterlyGrowth = revenueQuarterlyGrowth;
    }

    @JsonProperty("netIncomeToCommon")
    public NetIncomeToCommon getNetIncomeToCommon() {
        return netIncomeToCommon;
    }

    @JsonProperty("netIncomeToCommon")
    public void setNetIncomeToCommon(NetIncomeToCommon netIncomeToCommon) {
        this.netIncomeToCommon = netIncomeToCommon;
    }

    @JsonProperty("trailingEps")
    public TrailingEps getTrailingEps() {
        return trailingEps;
    }

    @JsonProperty("trailingEps")
    public void setTrailingEps(TrailingEps trailingEps) {
        this.trailingEps = trailingEps;
    }

    @JsonProperty("forwardEps")
    public ForwardEps getForwardEps() {
        return forwardEps;
    }

    @JsonProperty("forwardEps")
    public void setForwardEps(ForwardEps forwardEps) {
        this.forwardEps = forwardEps;
    }

    @JsonProperty("pegRatio")
    public PegRatio getPegRatio() {
        return pegRatio;
    }

    @JsonProperty("pegRatio")
    public void setPegRatio(PegRatio pegRatio) {
        this.pegRatio = pegRatio;
    }

    @JsonProperty("lastSplitFactor")
    public String getLastSplitFactor() {
        return lastSplitFactor;
    }

    @JsonProperty("lastSplitFactor")
    public void setLastSplitFactor(String lastSplitFactor) {
        this.lastSplitFactor = lastSplitFactor;
    }

    @JsonProperty("lastSplitDate")
    public LastSplitDate getLastSplitDate() {
        return lastSplitDate;
    }

    @JsonProperty("lastSplitDate")
    public void setLastSplitDate(LastSplitDate lastSplitDate) {
        this.lastSplitDate = lastSplitDate;
    }

    @JsonProperty("enterpriseToRevenue")
    public EnterpriseToRevenue getEnterpriseToRevenue() {
        return enterpriseToRevenue;
    }

    @JsonProperty("enterpriseToRevenue")
    public void setEnterpriseToRevenue(EnterpriseToRevenue enterpriseToRevenue) {
        this.enterpriseToRevenue = enterpriseToRevenue;
    }

    @JsonProperty("enterpriseToEbitda")
    public EnterpriseToEbitda getEnterpriseToEbitda() {
        return enterpriseToEbitda;
    }

    @JsonProperty("enterpriseToEbitda")
    public void setEnterpriseToEbitda(EnterpriseToEbitda enterpriseToEbitda) {
        this.enterpriseToEbitda = enterpriseToEbitda;
    }

    @JsonProperty("52WeekChange")
    public com.tranzmind.wealth.finance.stock.entity._52WeekChange get52WeekChange() {
        return _52WeekChange;
    }

    @JsonProperty("52WeekChange")
    public void set52WeekChange(com.tranzmind.wealth.finance.stock.entity._52WeekChange _52WeekChange) {
        this._52WeekChange = _52WeekChange;
    }

    @JsonProperty("SandP52WeekChange")
    public SandP52WeekChange getSandP52WeekChange() {
        return sandP52WeekChange;
    }

    @JsonProperty("SandP52WeekChange")
    public void setSandP52WeekChange(SandP52WeekChange sandP52WeekChange) {
        this.sandP52WeekChange = sandP52WeekChange;
    }

    @JsonProperty("lastDividendValue")
    public LastDividendValue getLastDividendValue() {
        return lastDividendValue;
    }

    @JsonProperty("lastDividendValue")
    public void setLastDividendValue(LastDividendValue lastDividendValue) {
        this.lastDividendValue = lastDividendValue;
    }

    @JsonProperty("lastCapGain")
    public LastCapGain getLastCapGain() {
        return lastCapGain;
    }

    @JsonProperty("lastCapGain")
    public void setLastCapGain(LastCapGain lastCapGain) {
        this.lastCapGain = lastCapGain;
    }

    @JsonProperty("annualHoldingsTurnover")
    public AnnualHoldingsTurnover getAnnualHoldingsTurnover() {
        return annualHoldingsTurnover;
    }

    @JsonProperty("annualHoldingsTurnover")
    public void setAnnualHoldingsTurnover(AnnualHoldingsTurnover annualHoldingsTurnover) {
        this.annualHoldingsTurnover = annualHoldingsTurnover;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
