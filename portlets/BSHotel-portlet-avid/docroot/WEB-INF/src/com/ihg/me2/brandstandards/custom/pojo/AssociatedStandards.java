package com.ihg.me2.brandstandards.custom.pojo;

import com.liferay.portal.kernel.json.JSONObject;

/**
 * <a href="AssociatedStandards.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author Niranjan Khandekar
 */
public class AssociatedStandards
{
    private String stdName;
    private String stdType;
    private long stdId;
    private AverageScore textClarityAvg;
    private AverageScore designSolutionAvg;
    private AverageScore sopQualityAvg;
    private AverageScore trainingMaterialAvg;
    private AverageScore qualityOfSupportAvg;
    private AverageScore qualityOfTranslationAvg;
    private String publishDate;
    private String complianceDate;
    private String stdDescription;
    private String stdStatus;
    private String stdWaiver;

    /**
     * 
     * @return String
     */
    public String getStdWaiver()
    {
        return stdWaiver;
    }

    /**
     * 
     * @param stdWaiver This is a String object
     */
    public void setStdWaiver(String stdWaiver)
    {
        this.stdWaiver = stdWaiver;
    }

    /**
     * 
     * @return String
     */
    public String getStdStatus()
    {
        return stdStatus;
    }

    /**
     * 
     * @param stdStatus This is a String object
     */
    public void setStdStatus(String stdStatus)
    {
        this.stdStatus = stdStatus;
    }

    /**
     * 
     * @return String
     */
    public String getPublishDate()
    {
        return publishDate;
    }

    /**
     * 
     * @param publishDate This is a String object
     */
    public void setPublishDate(String publishDate)
    {
        this.publishDate = publishDate;
    }

    /**
     * 
     * @return String
     */
    public String getComplianceDate()
    {
        return complianceDate;
    }

    /**
     * 
     * @param complianceDate This is a String object
     */
    public void setComplianceDate(String complianceDate)
    {
        this.complianceDate = complianceDate;
    }

    /**
     * 
     * @return String
     */
    public String getStdDescription()
    {
        return stdDescription;
    }

    /**
     * 
     * @param stdDescription This is a String object
     */
    public void setStdDescription(String stdDescription)
    {
        this.stdDescription = stdDescription;
    }

    /**
     * 
     * @return AverageScore
     */
    public AverageScore getTextClarityAvg()
    {
        return textClarityAvg;
    }

    /**
     * 
     * @param textClarityAvg This is AverageScore object
     */
    public void setTextClarityAvg(AverageScore textClarityAvg)
    {
        this.textClarityAvg = textClarityAvg;
    }

    /**
     * 
     * @return AverageScore
     */
    public AverageScore getDesignSolutionAvg()
    {
        return designSolutionAvg;
    }

    /**
     * 
     * @param designSolutionAvg This is an AverageScore object
     */
    public void setDesignSolutionAvg(AverageScore designSolutionAvg)
    {
        this.designSolutionAvg = designSolutionAvg;
    }

    /**
     * 
     * @return AverageScore
     */
    public AverageScore getSopQualityAvg()
    {
        return sopQualityAvg;
    }

    /**
     * 
     * @param sopQualityAvg This is an AverageScore object
     */
    public void setSopQualityAvg(AverageScore sopQualityAvg)
    {
        this.sopQualityAvg = sopQualityAvg;
    }

    /**
     * 
     * @return AverageScore
     */
    public AverageScore getTrainingMaterialAvg()
    {
        return trainingMaterialAvg;
    }

    /**
     * 
     * @param trainingMaterialAvg This is an AverageScore object
     */
    public void setTrainingMaterialAvg(AverageScore trainingMaterialAvg)
    {
        this.trainingMaterialAvg = trainingMaterialAvg;
    }

    /**
     * 
     * @return AverageScore
     */
    public AverageScore getQualityOfSupportAvg()
    {
        return qualityOfSupportAvg;
    }

    /**
     * 
     * @param qualityOfSupportAvg This is an AverageScore object
     */
    public void setQualityOfSupportAvg(AverageScore qualityOfSupportAvg)
    {
        this.qualityOfSupportAvg = qualityOfSupportAvg;
    }

    /**
     * 
     * @return AverageScore
     */
    public AverageScore getQualityOfTranslationAvg()
    {
        return qualityOfTranslationAvg;
    }

    /**
     * 
     * @param qualityOfTranslationAvg This is an AverageScore object
     */
    public void setQualityOfTranslationAvg(AverageScore qualityOfTranslationAvg)
    {
        this.qualityOfTranslationAvg = qualityOfTranslationAvg;
    }

    /**
     * 
     * @return String
     */
    public String getStdName()
    {
        return stdName;
    }

    /**
     * 
     * @param stdName This is a String object
     */
    public void setStdName(String stdName)
    {
        this.stdName = stdName;
    }

    /**
     * 
     * @return String
     */
    public String getStdType()
    {
        return stdType;
    }

    /**
     * 
     * @param stdType This is a String object
     */
    public void setStdType(String stdType)
    {
        this.stdType = stdType;
    }

    /**
     * 
     * @return long
     */
    public long getStdId()
    {
        return stdId;
    }

    /**
     * 
     * @param stdId This is a long object
     */
    public void setStdId(long stdId)
    {
        this.stdId = stdId;
    }

    /**
     * @author Chintan
     */
    public class AverageScore
    {
        private double avgScore;
        private int totalVotes;

        /**
         * 
         * @param jsonObject This is a JSONObject object
         */
        public AverageScore(JSONObject jsonObject)
        {
            this.setAvgScore(jsonObject.getDouble("averageScore"));
            this.setTotalVotes(jsonObject.getInt("totalVotes"));
        }

        /**
         * 
         * @return double
         */
        public double getAvgScore()
        {
            return avgScore;
        }

        /**
         * 
         * @param avgScore This is a double object
         */
        public void setAvgScore(double avgScore)
        {
            this.avgScore = avgScore;
        }

        /**
         * 
         * @return int
         */
        public int getTotalVotes()
        {
            return totalVotes;
        }

        /**
         * 
         * @param totalVotes This is an Integer object
         */
        public void setTotalVotes(int totalVotes)
        {
            this.totalVotes = totalVotes;
        }
    }

}
