package com.zjxc.video.etldata.beanObject;

import java.util.List;

public class FaceListObjectClass {
    /**
     * FaceListObject : {"FaceObject":[{"FaceID":"650100000011900000010220171219100515999830656599","InfoKind":1,"SourceID":"66000000001190123456022017120110101000007","DeviceID":"55000111221190000007","LeftTopX":1,"LeftTopY":1,"RightBtmX":1,"RightBtmY":1,"LocationMarkTime":"19981230010000","FaceAppearTime":"19981230010000","FaceDisAppearTime":"19981230010000","IDType":"111","IDNumber":"1","Name":"大华","UsedName":"dahua","Alias":"dahua","GenderCode":"1","AgeUpLimit":10,"AgeLowerLimit":20,"EthicCode":"01","NationalityCode":"CHN","NativeCityCode":"330108","ResidenceAdminDivision":"330100","ChineseAccentCode":"1","JobCategory":"1","AccompanyNumber":1,"SkinColor":"1","HairStyle":"1","HairColor":"1","FaceStyle":"1","FacialFeature":"1","PhysicalFeature":"1","RespiratorColor":"1","CapStyle":"1","CapColor":"1","GlassStyle":"1","GlassColor":"1","IsDriver":1,"IsForeigner":1,"PassportType":"1","ImmigrantTypeCode":"1","IsSuspectedTerrorist":1,"SuspectedTerroristNumber":"1","IsCriminalInvolved":1,"CriminalInvolvedSpecilisationCode":"1","BodySpeciallMark":"1","CrimeMethod":"1","CrimeCharacterCode":"111","EscapedCriminalNumber":"11111111111111111111111","IsDetainees":1,"DetentionHouseCode":"111111111","DetaineesIdentity":"1","DetaineesSpecialIdentity":"1","MemberTypeCode":"1","IsVictim":1,"VictimType":"1","InjuredDegree":"1","CorpseConditionCode":"1","IsSuspiciousPerson":1,"Attitude":1,"Similaritydegree":1,"EyebrowStyle":"1","NoseStyle":"1","MustacheStyle":"1","LipStyle":"1","WrinklePouch":"1","AcneStain":"1","FreckleBirthmark":"1","ScarDimple":"1","OtherFeature":"1","SubImageList":{"SubImageInfoObject":[{"ImageID":"33020300001190000001022017122111111100001","EventSort":11,"DeviceID":"33070299011190000253","StoragePath":"http://10.33.6.108:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg","Type":"01","FileFormat":"Jpeg","ShotTime":"20170825032455","Width":437,"Height":350}]}}]}
     */

    private FaceListObjectBean FaceListObject;

    public FaceListObjectBean getFaceListObject() {
        return FaceListObject;
    }

    public void setFaceListObject(FaceListObjectBean FaceListObject) {
        this.FaceListObject = FaceListObject;
    }

    public static class FaceListObjectBean {
        private List<FaceObjectBean> FaceObject;

        public List<FaceObjectBean> getFaceObject() {
            return FaceObject;
        }

        public void setFaceObject(List<FaceObjectBean> FaceObject) {
            this.FaceObject = FaceObject;
        }

        public static class FaceObjectBean {
            /**
             * FaceID : 650100000011900000010220171219100515999830656599
             * InfoKind : 1
             * SourceID : 66000000001190123456022017120110101000007
             * DeviceID : 55000111221190000007
             * LeftTopX : 1
             * LeftTopY : 1
             * RightBtmX : 1
             * RightBtmY : 1
             * LocationMarkTime : 19981230010000
             * FaceAppearTime : 19981230010000
             * FaceDisAppearTime : 19981230010000
             * IDType : 111
             * IDNumber : 1
             * Name : 大华
             * UsedName : dahua
             * Alias : dahua
             * GenderCode : 1
             * AgeUpLimit : 10
             * AgeLowerLimit : 20
             * EthicCode : 01
             * NationalityCode : CHN
             * NativeCityCode : 330108
             * ResidenceAdminDivision : 330100
             * ChineseAccentCode : 1
             * JobCategory : 1
             * AccompanyNumber : 1
             * SkinColor : 1
             * HairStyle : 1
             * HairColor : 1
             * FaceStyle : 1
             * FacialFeature : 1
             * PhysicalFeature : 1
             * RespiratorColor : 1
             * CapStyle : 1
             * CapColor : 1
             * GlassStyle : 1
             * GlassColor : 1
             * IsDriver : 1
             * IsForeigner : 1
             * PassportType : 1
             * ImmigrantTypeCode : 1
             * IsSuspectedTerrorist : 1
             * SuspectedTerroristNumber : 1
             * IsCriminalInvolved : 1
             * CriminalInvolvedSpecilisationCode : 1
             * BodySpeciallMark : 1
             * CrimeMethod : 1
             * CrimeCharacterCode : 111
             * EscapedCriminalNumber : 11111111111111111111111
             * IsDetainees : 1
             * DetentionHouseCode : 111111111
             * DetaineesIdentity : 1
             * DetaineesSpecialIdentity : 1
             * MemberTypeCode : 1
             * IsVictim : 1
             * VictimType : 1
             * InjuredDegree : 1
             * CorpseConditionCode : 1
             * IsSuspiciousPerson : 1
             * Attitude : 1
             * Similaritydegree : 1
             * EyebrowStyle : 1
             * NoseStyle : 1
             * MustacheStyle : 1
             * LipStyle : 1
             * WrinklePouch : 1
             * AcneStain : 1
             * FreckleBirthmark : 1
             * ScarDimple : 1
             * OtherFeature : 1
             * SubImageList : {"SubImageInfoObject":[{"ImageID":"33020300001190000001022017122111111100001","EventSort":11,"DeviceID":"33070299011190000253","StoragePath":"http://10.33.6.108:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg","Type":"01","FileFormat":"Jpeg","ShotTime":"20170825032455","Width":437,"Height":350}]}
             */

            private String FaceID;
            private int InfoKind;
            private String SourceID;
            private String DeviceID;
            private int LeftTopX;
            private int LeftTopY;
            private int RightBtmX;
            private int RightBtmY;
            private String LocationMarkTime;
            private String FaceAppearTime;
            private String FaceDisAppearTime;
            private String IDType;
            private String IDNumber;
            private String Name;
            private String UsedName;
            private String Alias;
            private String GenderCode;
            private int AgeUpLimit;
            private int AgeLowerLimit;
            private String EthicCode;
            private String NationalityCode;
            private String NativeCityCode;
            private String ResidenceAdminDivision;
            private String ChineseAccentCode;
            private String JobCategory;
            private int AccompanyNumber;
            private String SkinColor;
            private String HairStyle;
            private String HairColor;
            private String FaceStyle;
            private String FacialFeature;
            private String PhysicalFeature;
            private String RespiratorColor;
            private String CapStyle;
            private String CapColor;
            private String GlassStyle;
            private String GlassColor;
            private int IsDriver;
            private int IsForeigner;
            private String PassportType;
            private String ImmigrantTypeCode;
            private int IsSuspectedTerrorist;
            private String SuspectedTerroristNumber;
            private int IsCriminalInvolved;
            private String CriminalInvolvedSpecilisationCode;
            private String BodySpeciallMark;
            private String CrimeMethod;
            private String CrimeCharacterCode;
            private String EscapedCriminalNumber;
            private int IsDetainees;
            private String DetentionHouseCode;
            private String DetaineesIdentity;
            private String DetaineesSpecialIdentity;
            private String MemberTypeCode;
            private int IsVictim;
            private String VictimType;
            private String InjuredDegree;
            private String CorpseConditionCode;
            private int IsSuspiciousPerson;
            private int Attitude;
            private int Similaritydegree;
            private String EyebrowStyle;
            private String NoseStyle;
            private String MustacheStyle;
            private String LipStyle;
            private String WrinklePouch;
            private String AcneStain;
            private String FreckleBirthmark;
            private String ScarDimple;
            private String OtherFeature;
            private SubImageListBean SubImageList;

            public String getFaceID() {
                return FaceID;
            }

            public void setFaceID(String FaceID) {
                this.FaceID = FaceID;
            }

            public int getInfoKind() {
                return InfoKind;
            }

            public void setInfoKind(int InfoKind) {
                this.InfoKind = InfoKind;
            }

            public String getSourceID() {
                return SourceID;
            }

            public void setSourceID(String SourceID) {
                this.SourceID = SourceID;
            }

            public String getDeviceID() {
                return DeviceID;
            }

            public void setDeviceID(String DeviceID) {
                this.DeviceID = DeviceID;
            }

            public int getLeftTopX() {
                return LeftTopX;
            }

            public void setLeftTopX(int LeftTopX) {
                this.LeftTopX = LeftTopX;
            }

            public int getLeftTopY() {
                return LeftTopY;
            }

            public void setLeftTopY(int LeftTopY) {
                this.LeftTopY = LeftTopY;
            }

            public int getRightBtmX() {
                return RightBtmX;
            }

            public void setRightBtmX(int RightBtmX) {
                this.RightBtmX = RightBtmX;
            }

            public int getRightBtmY() {
                return RightBtmY;
            }

            public void setRightBtmY(int RightBtmY) {
                this.RightBtmY = RightBtmY;
            }

            public String getLocationMarkTime() {
                return LocationMarkTime;
            }

            public void setLocationMarkTime(String LocationMarkTime) {
                this.LocationMarkTime = LocationMarkTime;
            }

            public String getFaceAppearTime() {
                return FaceAppearTime;
            }

            public void setFaceAppearTime(String FaceAppearTime) {
                this.FaceAppearTime = FaceAppearTime;
            }

            public String getFaceDisAppearTime() {
                return FaceDisAppearTime;
            }

            public void setFaceDisAppearTime(String FaceDisAppearTime) {
                this.FaceDisAppearTime = FaceDisAppearTime;
            }

            public String getIDType() {
                return IDType;
            }

            public void setIDType(String IDType) {
                this.IDType = IDType;
            }

            public String getIDNumber() {
                return IDNumber;
            }

            public void setIDNumber(String IDNumber) {
                this.IDNumber = IDNumber;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getUsedName() {
                return UsedName;
            }

            public void setUsedName(String UsedName) {
                this.UsedName = UsedName;
            }

            public String getAlias() {
                return Alias;
            }

            public void setAlias(String Alias) {
                this.Alias = Alias;
            }

            public String getGenderCode() {
                return GenderCode;
            }

            public void setGenderCode(String GenderCode) {
                this.GenderCode = GenderCode;
            }

            public int getAgeUpLimit() {
                return AgeUpLimit;
            }

            public void setAgeUpLimit(int AgeUpLimit) {
                this.AgeUpLimit = AgeUpLimit;
            }

            public int getAgeLowerLimit() {
                return AgeLowerLimit;
            }

            public void setAgeLowerLimit(int AgeLowerLimit) {
                this.AgeLowerLimit = AgeLowerLimit;
            }

            public String getEthicCode() {
                return EthicCode;
            }

            public void setEthicCode(String EthicCode) {
                this.EthicCode = EthicCode;
            }

            public String getNationalityCode() {
                return NationalityCode;
            }

            public void setNationalityCode(String NationalityCode) {
                this.NationalityCode = NationalityCode;
            }

            public String getNativeCityCode() {
                return NativeCityCode;
            }

            public void setNativeCityCode(String NativeCityCode) {
                this.NativeCityCode = NativeCityCode;
            }

            public String getResidenceAdminDivision() {
                return ResidenceAdminDivision;
            }

            public void setResidenceAdminDivision(String ResidenceAdminDivision) {
                this.ResidenceAdminDivision = ResidenceAdminDivision;
            }

            public String getChineseAccentCode() {
                return ChineseAccentCode;
            }

            public void setChineseAccentCode(String ChineseAccentCode) {
                this.ChineseAccentCode = ChineseAccentCode;
            }

            public String getJobCategory() {
                return JobCategory;
            }

            public void setJobCategory(String JobCategory) {
                this.JobCategory = JobCategory;
            }

            public int getAccompanyNumber() {
                return AccompanyNumber;
            }

            public void setAccompanyNumber(int AccompanyNumber) {
                this.AccompanyNumber = AccompanyNumber;
            }

            public String getSkinColor() {
                return SkinColor;
            }

            public void setSkinColor(String SkinColor) {
                this.SkinColor = SkinColor;
            }

            public String getHairStyle() {
                return HairStyle;
            }

            public void setHairStyle(String HairStyle) {
                this.HairStyle = HairStyle;
            }

            public String getHairColor() {
                return HairColor;
            }

            public void setHairColor(String HairColor) {
                this.HairColor = HairColor;
            }

            public String getFaceStyle() {
                return FaceStyle;
            }

            public void setFaceStyle(String FaceStyle) {
                this.FaceStyle = FaceStyle;
            }

            public String getFacialFeature() {
                return FacialFeature;
            }

            public void setFacialFeature(String FacialFeature) {
                this.FacialFeature = FacialFeature;
            }

            public String getPhysicalFeature() {
                return PhysicalFeature;
            }

            public void setPhysicalFeature(String PhysicalFeature) {
                this.PhysicalFeature = PhysicalFeature;
            }

            public String getRespiratorColor() {
                return RespiratorColor;
            }

            public void setRespiratorColor(String RespiratorColor) {
                this.RespiratorColor = RespiratorColor;
            }

            public String getCapStyle() {
                return CapStyle;
            }

            public void setCapStyle(String CapStyle) {
                this.CapStyle = CapStyle;
            }

            public String getCapColor() {
                return CapColor;
            }

            public void setCapColor(String CapColor) {
                this.CapColor = CapColor;
            }

            public String getGlassStyle() {
                return GlassStyle;
            }

            public void setGlassStyle(String GlassStyle) {
                this.GlassStyle = GlassStyle;
            }

            public String getGlassColor() {
                return GlassColor;
            }

            public void setGlassColor(String GlassColor) {
                this.GlassColor = GlassColor;
            }

            public int getIsDriver() {
                return IsDriver;
            }

            public void setIsDriver(int IsDriver) {
                this.IsDriver = IsDriver;
            }

            public int getIsForeigner() {
                return IsForeigner;
            }

            public void setIsForeigner(int IsForeigner) {
                this.IsForeigner = IsForeigner;
            }

            public String getPassportType() {
                return PassportType;
            }

            public void setPassportType(String PassportType) {
                this.PassportType = PassportType;
            }

            public String getImmigrantTypeCode() {
                return ImmigrantTypeCode;
            }

            public void setImmigrantTypeCode(String ImmigrantTypeCode) {
                this.ImmigrantTypeCode = ImmigrantTypeCode;
            }

            public int getIsSuspectedTerrorist() {
                return IsSuspectedTerrorist;
            }

            public void setIsSuspectedTerrorist(int IsSuspectedTerrorist) {
                this.IsSuspectedTerrorist = IsSuspectedTerrorist;
            }

            public String getSuspectedTerroristNumber() {
                return SuspectedTerroristNumber;
            }

            public void setSuspectedTerroristNumber(String SuspectedTerroristNumber) {
                this.SuspectedTerroristNumber = SuspectedTerroristNumber;
            }

            public int getIsCriminalInvolved() {
                return IsCriminalInvolved;
            }

            public void setIsCriminalInvolved(int IsCriminalInvolved) {
                this.IsCriminalInvolved = IsCriminalInvolved;
            }

            public String getCriminalInvolvedSpecilisationCode() {
                return CriminalInvolvedSpecilisationCode;
            }

            public void setCriminalInvolvedSpecilisationCode(String CriminalInvolvedSpecilisationCode) {
                this.CriminalInvolvedSpecilisationCode = CriminalInvolvedSpecilisationCode;
            }

            public String getBodySpeciallMark() {
                return BodySpeciallMark;
            }

            public void setBodySpeciallMark(String BodySpeciallMark) {
                this.BodySpeciallMark = BodySpeciallMark;
            }

            public String getCrimeMethod() {
                return CrimeMethod;
            }

            public void setCrimeMethod(String CrimeMethod) {
                this.CrimeMethod = CrimeMethod;
            }

            public String getCrimeCharacterCode() {
                return CrimeCharacterCode;
            }

            public void setCrimeCharacterCode(String CrimeCharacterCode) {
                this.CrimeCharacterCode = CrimeCharacterCode;
            }

            public String getEscapedCriminalNumber() {
                return EscapedCriminalNumber;
            }

            public void setEscapedCriminalNumber(String EscapedCriminalNumber) {
                this.EscapedCriminalNumber = EscapedCriminalNumber;
            }

            public int getIsDetainees() {
                return IsDetainees;
            }

            public void setIsDetainees(int IsDetainees) {
                this.IsDetainees = IsDetainees;
            }

            public String getDetentionHouseCode() {
                return DetentionHouseCode;
            }

            public void setDetentionHouseCode(String DetentionHouseCode) {
                this.DetentionHouseCode = DetentionHouseCode;
            }

            public String getDetaineesIdentity() {
                return DetaineesIdentity;
            }

            public void setDetaineesIdentity(String DetaineesIdentity) {
                this.DetaineesIdentity = DetaineesIdentity;
            }

            public String getDetaineesSpecialIdentity() {
                return DetaineesSpecialIdentity;
            }

            public void setDetaineesSpecialIdentity(String DetaineesSpecialIdentity) {
                this.DetaineesSpecialIdentity = DetaineesSpecialIdentity;
            }

            public String getMemberTypeCode() {
                return MemberTypeCode;
            }

            public void setMemberTypeCode(String MemberTypeCode) {
                this.MemberTypeCode = MemberTypeCode;
            }

            public int getIsVictim() {
                return IsVictim;
            }

            public void setIsVictim(int IsVictim) {
                this.IsVictim = IsVictim;
            }

            public String getVictimType() {
                return VictimType;
            }

            public void setVictimType(String VictimType) {
                this.VictimType = VictimType;
            }

            public String getInjuredDegree() {
                return InjuredDegree;
            }

            public void setInjuredDegree(String InjuredDegree) {
                this.InjuredDegree = InjuredDegree;
            }

            public String getCorpseConditionCode() {
                return CorpseConditionCode;
            }

            public void setCorpseConditionCode(String CorpseConditionCode) {
                this.CorpseConditionCode = CorpseConditionCode;
            }

            public int getIsSuspiciousPerson() {
                return IsSuspiciousPerson;
            }

            public void setIsSuspiciousPerson(int IsSuspiciousPerson) {
                this.IsSuspiciousPerson = IsSuspiciousPerson;
            }

            public int getAttitude() {
                return Attitude;
            }

            public void setAttitude(int Attitude) {
                this.Attitude = Attitude;
            }

            public int getSimilaritydegree() {
                return Similaritydegree;
            }

            public void setSimilaritydegree(int Similaritydegree) {
                this.Similaritydegree = Similaritydegree;
            }

            public String getEyebrowStyle() {
                return EyebrowStyle;
            }

            public void setEyebrowStyle(String EyebrowStyle) {
                this.EyebrowStyle = EyebrowStyle;
            }

            public String getNoseStyle() {
                return NoseStyle;
            }

            public void setNoseStyle(String NoseStyle) {
                this.NoseStyle = NoseStyle;
            }

            public String getMustacheStyle() {
                return MustacheStyle;
            }

            public void setMustacheStyle(String MustacheStyle) {
                this.MustacheStyle = MustacheStyle;
            }

            public String getLipStyle() {
                return LipStyle;
            }

            public void setLipStyle(String LipStyle) {
                this.LipStyle = LipStyle;
            }

            public String getWrinklePouch() {
                return WrinklePouch;
            }

            public void setWrinklePouch(String WrinklePouch) {
                this.WrinklePouch = WrinklePouch;
            }

            public String getAcneStain() {
                return AcneStain;
            }

            public void setAcneStain(String AcneStain) {
                this.AcneStain = AcneStain;
            }

            public String getFreckleBirthmark() {
                return FreckleBirthmark;
            }

            public void setFreckleBirthmark(String FreckleBirthmark) {
                this.FreckleBirthmark = FreckleBirthmark;
            }

            public String getScarDimple() {
                return ScarDimple;
            }

            public void setScarDimple(String ScarDimple) {
                this.ScarDimple = ScarDimple;
            }

            public String getOtherFeature() {
                return OtherFeature;
            }

            public void setOtherFeature(String OtherFeature) {
                this.OtherFeature = OtherFeature;
            }

            public SubImageListBean getSubImageList() {
                return SubImageList;
            }

            public void setSubImageList(SubImageListBean SubImageList) {
                this.SubImageList = SubImageList;
            }

            public static class SubImageListBean {
                private List<SubImageInfoObjectBean> SubImageInfoObject;

                public List<SubImageInfoObjectBean> getSubImageInfoObject() {
                    return SubImageInfoObject;
                }

                public void setSubImageInfoObject(List<SubImageInfoObjectBean> SubImageInfoObject) {
                    this.SubImageInfoObject = SubImageInfoObject;
                }

                public static class SubImageInfoObjectBean {
                    /**
                     * ImageID : 33020300001190000001022017122111111100001
                     * EventSort : 11
                     * DeviceID : 33070299011190000253
                     * StoragePath : http://10.33.6.108:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg
                     * Type : 01
                     * FileFormat : Jpeg
                     * ShotTime : 20170825032455
                     * Width : 437
                     * Height : 350
                     */

                    private String ImageID;
                    private int EventSort;
                    private String DeviceID;
                    private String StoragePath;
                    private String Type;
                    private String FileFormat;
                    private String ShotTime;
                    private int Width;
                    private int Height;

                    public String getImageID() {
                        return ImageID;
                    }

                    public void setImageID(String ImageID) {
                        this.ImageID = ImageID;
                    }

                    public int getEventSort() {
                        return EventSort;
                    }

                    public void setEventSort(int EventSort) {
                        this.EventSort = EventSort;
                    }

                    public String getDeviceID() {
                        return DeviceID;
                    }

                    public void setDeviceID(String DeviceID) {
                        this.DeviceID = DeviceID;
                    }

                    public String getStoragePath() {
                        return StoragePath;
                    }

                    public void setStoragePath(String StoragePath) {
                        this.StoragePath = StoragePath;
                    }

                    public String getType() {
                        return Type;
                    }

                    public void setType(String Type) {
                        this.Type = Type;
                    }

                    public String getFileFormat() {
                        return FileFormat;
                    }

                    public void setFileFormat(String FileFormat) {
                        this.FileFormat = FileFormat;
                    }

                    public String getShotTime() {
                        return ShotTime;
                    }

                    public void setShotTime(String ShotTime) {
                        this.ShotTime = ShotTime;
                    }

                    public int getWidth() {
                        return Width;
                    }

                    public void setWidth(int Width) {
                        this.Width = Width;
                    }

                    public int getHeight() {
                        return Height;
                    }

                    public void setHeight(int Height) {
                        this.Height = Height;
                    }
                }
            }
        }
    }
}
