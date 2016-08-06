package com.android.applidecathlon.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Elias on 05/08/2016.
 */
public class Store {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("countryCode")
    private String countryCode;
    @SerializedName("country")
    private String country;
    @SerializedName("directorSignature")
    private Object directorSignature;
    @SerializedName("address2")
    private Object address2;
    @SerializedName("city")
    private String city;
    @SerializedName("postalCode")
    private String postalCode;
    @SerializedName("region")
    private String region;
    @SerializedName("ebookingPhone")
    private Object ebookingPhone;
    @SerializedName("phone")
    private String phone;
    @SerializedName("gpsX")
    private Double gpsX;
    @SerializedName("gpsY")
    private Double gpsY;
    @SerializedName("fax")
    private Object fax;
    @SerializedName("facebookUrl")
    private String facebookUrl;
    @SerializedName("twitterAccount")
    private Object twitterAccount;
    @SerializedName("welcomePicture")
    private Object welcomePicture;
    @SerializedName("selfScanning")
    private Boolean selfScanning;
    @SerializedName("openingStore")
    private Boolean openingStore;
    @SerializedName("workshop")
    private Boolean workshop;
    @SerializedName("storeReviews")
    private Boolean storeReviews;
    @SerializedName("contactUrl")
    private Object contactUrl;
    @SerializedName("directorLastName")
    private Object directorLastName;
    @SerializedName("address")
    private String address;

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode The countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return The directorSignature
     */
    public Object getDirectorSignature() {
        return directorSignature;
    }

    /**
     * @param directorSignature The directorSignature
     */
    public void setDirectorSignature(Object directorSignature) {
        this.directorSignature = directorSignature;
    }

    /**
     * @return The address2
     */
    public Object getAddress2() {
        return address2;
    }

    /**
     * @param address2 The address2
     */
    public void setAddress2(Object address2) {
        this.address2 = address2;
    }

    /**
     * @return The city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return The postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode The postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return The region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region The region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return The ebookingPhone
     */
    public Object getEbookingPhone() {
        return ebookingPhone;
    }

    /**
     * @param ebookingPhone The ebookingPhone
     */
    public void setEbookingPhone(Object ebookingPhone) {
        this.ebookingPhone = ebookingPhone;
    }

    /**
     * @return The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return The gpsX
     */
    public Double getGpsX() {
        return gpsX;
    }

    /**
     * @param gpsX The gpsX
     */
    public void setGpsX(Double gpsX) {
        this.gpsX = gpsX;
    }

    /**
     * @return The gpsY
     */
    public Double getGpsY() {
        return gpsY;
    }

    /**
     * @param gpsY The gpsY
     */
    public void setGpsY(Double gpsY) {
        this.gpsY = gpsY;
    }

    /**
     * @return The fax
     */
    public Object getFax() {
        return fax;
    }

    /**
     * @param fax The fax
     */
    public void setFax(Object fax) {
        this.fax = fax;
    }

    /**
     * @return The facebookUrl
     */
    public String getFacebookUrl() {
        return facebookUrl;
    }

    /**
     * @param facebookUrl The facebookUrl
     */
    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    /**
     * @return The twitterAccount
     */
    public Object getTwitterAccount() {
        return twitterAccount;
    }

    /**
     * @param twitterAccount The twitterAccount
     */
    public void setTwitterAccount(Object twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

    /**
     * @return The welcomePicture
     */
    public Object getWelcomePicture() {
        return welcomePicture;
    }

    /**
     * @param welcomePicture The welcomePicture
     */
    public void setWelcomePicture(Object welcomePicture) {
        this.welcomePicture = welcomePicture;
    }

    /**
     * @return The selfScanning
     */
    public Boolean getSelfScanning() {
        return selfScanning;
    }

    /**
     * @param selfScanning The selfScanning
     */
    public void setSelfScanning(Boolean selfScanning) {
        this.selfScanning = selfScanning;
    }

    /**
     * @return The openingStore
     */
    public Boolean getOpeningStore() {
        return openingStore;
    }

    /**
     * @param openingStore The openingStore
     */
    public void setOpeningStore(Boolean openingStore) {
        this.openingStore = openingStore;
    }

    /**
     * @return The workshop
     */
    public Boolean getWorkshop() {
        return workshop;
    }

    /**
     * @param workshop The workshop
     */
    public void setWorkshop(Boolean workshop) {
        this.workshop = workshop;
    }

    /**
     * @return The storeReviews
     */
    public Boolean getStoreReviews() {
        return storeReviews;
    }

    /**
     * @param storeReviews The storeReviews
     */
    public void setStoreReviews(Boolean storeReviews) {
        this.storeReviews = storeReviews;
    }

    /**
     * @return The contactUrl
     */
    public Object getContactUrl() {
        return contactUrl;
    }

    /**
     * @param contactUrl The contactUrl
     */
    public void setContactUrl(Object contactUrl) {
        this.contactUrl = contactUrl;
    }

    /**
     * @return The directorLastName
     */
    public Object getDirectorLastName() {
        return directorLastName;
    }

    /**
     * @param directorLastName The directorLastName
     */
    public void setDirectorLastName(Object directorLastName) {
        this.directorLastName = directorLastName;
    }

    /**
     * @return The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
