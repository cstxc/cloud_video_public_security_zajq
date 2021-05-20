package com.zjxc.video.etldata.beanObject;

import java.util.List;

public class PersonListObjectClass {

    /**
     * PersonListObject : {"PersonObject":[{"PersonID":"650100000011900000010220171219100515999830156479","InfoKind":1,"SourceID":"66000000001190123456022017120110101000007","DeviceID":"55000111221190000007","LeftTopX":1,"LeftTopY":1,"RightBtmX":1,"RightBtmY":1,"LocationMarkTime":"19981230010000","PersonAppearTime":"19981230010000","PersonDisAppearTime":"19981230010000","IDType":"111","IDNumber":"1","Name":"大华","UsedName":"dahua","Alias":"dahua","GenderCode":"1","AgeUpLimit":10,"AgeLowerLimit":20,"EthicCode":"1","NationalityCode":"CHN","NativeCityCode":"330109","ResidenceAdminDivision":"330101","ChineseAccentCode":"2","PersonOrg":"浙江杭州","JobCategory":"2","AccompanyNumber":2,"HeightUpLimit":175,"HeightLowerLimit":130,"BodyType":"1","SkinColor":"1","HairStyle":"1","HairColor":"1","Gesture":"1","Status":"1","FaceStyle":"1","FacialFeature":"1","PhysicalFeature":"1","BodyFeature":"1","HabitualMovement":"1","Behavior":"1","BehaviorDescription":"走动","Appendant":"6","AppendantDescription":"眼镜磨碎","UmbrellaColor":"1","RespiratorColor":"1","CapStyle":"1","CapColor":"1","GlassStyle":"1","GlassColor":"1","ScarfColor":"1","BagStyle":"1","BagColor":"1","CoatStyle":"1","CoatLength":"2","CoatColor":"1","TrousersStyle":"1","TrousersColor":"1","TrousersLen":"2","ShoesStyle":"1","ShoesColor":"1","IsDriver":1,"IsForeigner":1,"PassportType":"99","ImmigrantTypeCode":"1","IsSuspectedTerrorist":1,"SuspectedTerroristNumber":"250","IsCriminalInvolved":1,"CriminalInvolvedSpecilisationCode":"1","BodySpeciallMark":"1","CrimeMethod":"1","CrimeCharacterCode":"285","EscapedCriminalNumber":"295","IsDetainees":1,"DetentionHouseCode":"520010000","DetaineesIdentity":"1","DetaineesSpecialIdentity":"1","MemberTypeCode":"1","IsVictim":1,"VictimType":"1","InjuredDegree":"1","CorpseConditionCode":"1","IsSuspiciousPerson":1,"SubImageList":{"SubImageInfoObject":[{"ImageID":"33020300001190000001022017122111111100011","EventSort":11,"DeviceID":"33070299011190000253","StoragePath":"http://10.33.6.108:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg","Type":"10","FileFormat":"Jpeg","ShotTime":"20170825032455","Width":437,"Height":350}]}}]}
     */

    private PersonListObjectBean PersonListObject;

    public PersonListObjectBean getPersonListObject() {
        return PersonListObject;
    }

    public void setPersonListObject(PersonListObjectBean PersonListObject) {
        this.PersonListObject = PersonListObject;
    }

    public static class PersonListObjectBean {
        private List<PersonObjectBean> PersonObject;

        public List<PersonObjectBean> getPersonObject() {
            return PersonObject;
        }

        public void setPersonObject(List<PersonObjectBean> PersonObject) {
            this.PersonObject = PersonObject;
        }

        public static class PersonObjectBean {
            /**
             * PersonID : 650100000011900000010220171219100515999830156479
             * InfoKind : 1
             * SourceID : 66000000001190123456022017120110101000007
             * DeviceID : 55000111221190000007
             * LeftTopX : 1
             * LeftTopY : 1
             * RightBtmX : 1
             * RightBtmY : 1
             * LocationMarkTime : 19981230010000
             * PersonAppearTime : 19981230010000
             * PersonDisAppearTime : 19981230010000
             * IDType : 111
             * IDNumber : 1
             * Name : 大华
             * UsedName : dahua
             * Alias : dahua
             * GenderCode : 1
             * AgeUpLimit : 10
             * AgeLowerLimit : 20
             * EthicCode : 1
             * NationalityCode : CHN
             * NativeCityCode : 330109
             * ResidenceAdminDivision : 330101
             * ChineseAccentCode : 2
             * PersonOrg : 浙江杭州
             * JobCategory : 2
             * AccompanyNumber : 2
             * HeightUpLimit : 175
             * HeightLowerLimit : 130
             * BodyType : 1
             * SkinColor : 1
             * HairStyle : 1
             * HairColor : 1
             * Gesture : 1
             * Status : 1
             * FaceStyle : 1
             * FacialFeature : 1
             * PhysicalFeature : 1
             * BodyFeature : 1
             * HabitualMovement : 1
             * Behavior : 1
             * BehaviorDescription : 走动
             * Appendant : 6
             * AppendantDescription : 眼镜磨碎
             * UmbrellaColor : 1
             * RespiratorColor : 1
             * CapStyle : 1
             * CapColor : 1
             * GlassStyle : 1
             * GlassColor : 1
             * ScarfColor : 1
             * BagStyle : 1
             * BagColor : 1
             * CoatStyle : 1
             * CoatLength : 2
             * CoatColor : 1
             * TrousersStyle : 1
             * TrousersColor : 1
             * TrousersLen : 2
             * ShoesStyle : 1
             * ShoesColor : 1
             * IsDriver : 1
             * IsForeigner : 1
             * PassportType : 99
             * ImmigrantTypeCode : 1
             * IsSuspectedTerrorist : 1
             * SuspectedTerroristNumber : 250
             * IsCriminalInvolved : 1
             * CriminalInvolvedSpecilisationCode : 1
             * BodySpeciallMark : 1
             * CrimeMethod : 1
             * CrimeCharacterCode : 285
             * EscapedCriminalNumber : 295
             * IsDetainees : 1
             * DetentionHouseCode : 520010000
             * DetaineesIdentity : 1
             * DetaineesSpecialIdentity : 1
             * MemberTypeCode : 1
             * IsVictim : 1
             * VictimType : 1
             * InjuredDegree : 1
             * CorpseConditionCode : 1
             * IsSuspiciousPerson : 1
             * SubImageList : {"SubImageInfoObject":[{"ImageID":"33020300001190000001022017122111111100011","EventSort":11,"DeviceID":"33070299011190000253","StoragePath":"http://10.33.6.108:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg","Type":"10","FileFormat":"Jpeg","ShotTime":"20170825032455","Width":437,"Height":350}]}
             */

            private String PersonID;
            private int InfoKind;
            private String SourceID;
            private String DeviceID;
            private int LeftTopX;
            private int LeftTopY;
            private int RightBtmX;
            private int RightBtmY;
            private String LocationMarkTime;
            private String PersonAppearTime;
            private String PersonDisAppearTime;
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
            private String PersonOrg;
            private String JobCategory;
            private int AccompanyNumber;
            private int HeightUpLimit;
            private int HeightLowerLimit;
            private String BodyType;
            private String SkinColor;
            private String HairStyle;
            private String HairColor;
            private String Gesture;
            private String Status;
            private String FaceStyle;
            private String FacialFeature;
            private String PhysicalFeature;
            private String BodyFeature;
            private String HabitualMovement;
            private String Behavior;
            private String BehaviorDescription;
            private String Appendant;
            private String AppendantDescription;
            private String UmbrellaColor;
            private String RespiratorColor;
            private String CapStyle;
            private String CapColor;
            private String GlassStyle;
            private String GlassColor;
            private String ScarfColor;
            private String BagStyle;
            private String BagColor;
            private String CoatStyle;
            private String CoatLength;
            private String CoatColor;
            private String TrousersStyle;
            private String TrousersColor;
            private String TrousersLen;
            private String ShoesStyle;
            private String ShoesColor;
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
            private SubImageListBean SubImageList;

            public String getPersonID() {
                return PersonID;
            }

            public void setPersonID(String PersonID) {
                this.PersonID = PersonID;
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

            public String getPersonAppearTime() {
                return PersonAppearTime;
            }

            public void setPersonAppearTime(String PersonAppearTime) {
                this.PersonAppearTime = PersonAppearTime;
            }

            public String getPersonDisAppearTime() {
                return PersonDisAppearTime;
            }

            public void setPersonDisAppearTime(String PersonDisAppearTime) {
                this.PersonDisAppearTime = PersonDisAppearTime;
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

            public String getPersonOrg() {
                return PersonOrg;
            }

            public void setPersonOrg(String PersonOrg) {
                this.PersonOrg = PersonOrg;
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

            public int getHeightUpLimit() {
                return HeightUpLimit;
            }

            public void setHeightUpLimit(int HeightUpLimit) {
                this.HeightUpLimit = HeightUpLimit;
            }

            public int getHeightLowerLimit() {
                return HeightLowerLimit;
            }

            public void setHeightLowerLimit(int HeightLowerLimit) {
                this.HeightLowerLimit = HeightLowerLimit;
            }

            public String getBodyType() {
                return BodyType;
            }

            public void setBodyType(String BodyType) {
                this.BodyType = BodyType;
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

            public String getGesture() {
                return Gesture;
            }

            public void setGesture(String Gesture) {
                this.Gesture = Gesture;
            }

            public String getStatus() {
                return Status;
            }

            public void setStatus(String Status) {
                this.Status = Status;
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

            public String getBodyFeature() {
                return BodyFeature;
            }

            public void setBodyFeature(String BodyFeature) {
                this.BodyFeature = BodyFeature;
            }

            public String getHabitualMovement() {
                return HabitualMovement;
            }

            public void setHabitualMovement(String HabitualMovement) {
                this.HabitualMovement = HabitualMovement;
            }

            public String getBehavior() {
                return Behavior;
            }

            public void setBehavior(String Behavior) {
                this.Behavior = Behavior;
            }

            public String getBehaviorDescription() {
                return BehaviorDescription;
            }

            public void setBehaviorDescription(String BehaviorDescription) {
                this.BehaviorDescription = BehaviorDescription;
            }

            public String getAppendant() {
                return Appendant;
            }

            public void setAppendant(String Appendant) {
                this.Appendant = Appendant;
            }

            public String getAppendantDescription() {
                return AppendantDescription;
            }

            public void setAppendantDescription(String AppendantDescription) {
                this.AppendantDescription = AppendantDescription;
            }

            public String getUmbrellaColor() {
                return UmbrellaColor;
            }

            public void setUmbrellaColor(String UmbrellaColor) {
                this.UmbrellaColor = UmbrellaColor;
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

            public String getScarfColor() {
                return ScarfColor;
            }

            public void setScarfColor(String ScarfColor) {
                this.ScarfColor = ScarfColor;
            }

            public String getBagStyle() {
                return BagStyle;
            }

            public void setBagStyle(String BagStyle) {
                this.BagStyle = BagStyle;
            }

            public String getBagColor() {
                return BagColor;
            }

            public void setBagColor(String BagColor) {
                this.BagColor = BagColor;
            }

            public String getCoatStyle() {
                return CoatStyle;
            }

            public void setCoatStyle(String CoatStyle) {
                this.CoatStyle = CoatStyle;
            }

            public String getCoatLength() {
                return CoatLength;
            }

            public void setCoatLength(String CoatLength) {
                this.CoatLength = CoatLength;
            }

            public String getCoatColor() {
                return CoatColor;
            }

            public void setCoatColor(String CoatColor) {
                this.CoatColor = CoatColor;
            }

            public String getTrousersStyle() {
                return TrousersStyle;
            }

            public void setTrousersStyle(String TrousersStyle) {
                this.TrousersStyle = TrousersStyle;
            }

            public String getTrousersColor() {
                return TrousersColor;
            }

            public void setTrousersColor(String TrousersColor) {
                this.TrousersColor = TrousersColor;
            }

            public String getTrousersLen() {
                return TrousersLen;
            }

            public void setTrousersLen(String TrousersLen) {
                this.TrousersLen = TrousersLen;
            }

            public String getShoesStyle() {
                return ShoesStyle;
            }

            public void setShoesStyle(String ShoesStyle) {
                this.ShoesStyle = ShoesStyle;
            }

            public String getShoesColor() {
                return ShoesColor;
            }

            public void setShoesColor(String ShoesColor) {
                this.ShoesColor = ShoesColor;
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
                     * ImageID : 33020300001190000001022017122111111100011
                     * EventSort : 11
                     * DeviceID : 33070299011190000253
                     * StoragePath : http://10.33.6.108:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg
                     * Type : 10
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
