package com.zjxc.video.etldata.beanObject;
/*
 *@ClassName  SceneListObjectClass
 *@description    TODO
 *@author     Whoami
 *@date   2020/7/24
 *@version 1.0
 */

import java.util.List;

public class SceneListObjectClass {

    /**
     * SceneListObject : {"SceneObject":[{"SceneID":"650100000011900000010220171219100515999830556499","InfoKind":1,"SourceID":"66000000001190123456022017120110101000008","DeviceID":"55000111221190000007","BeginTime":"19981230010000","PlaceType":"1100","WeatherType":"05","SceneDescribe":"天气良好","SceneType":"11","RoadAlignmentType":"11","RoadTerrainType":1,"RoadSurfaceType":"1","RoadCoditionType":"1","RoadJunctionSectionType":"11","RoadLightingType":"1","Illustration":"1","WindDirection":"东南","Illumination":"1","FieldCondition":"1","Temperature":25,"Humidity":"1","PopulationDensity":"1","DenseDegree":"1","Importance":4,"SubImageList":{"SubImageInfoObject":[{"ImageID":"33020300001190000001022017122111111100321","EventSort":4,"DeviceID":"55220299011190000253","StoragePath":"http://localhost:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg","Type":"14","FileFormat":"Jpeg","ShotTime":"20170925032455","Width":437,"Height":350}]}}]}
     */

    private SceneListObjectBean SceneListObject;

    public SceneListObjectBean getSceneListObject() {
        return SceneListObject;
    }

    public void setSceneListObject(SceneListObjectBean SceneListObject) {
        this.SceneListObject = SceneListObject;
    }

    public static class SceneListObjectBean {
        private List<SceneObjectBean> SceneObject;

        public List<SceneObjectBean> getSceneObject() {
            return SceneObject;
        }

        public void setSceneObject(List<SceneObjectBean> SceneObject) {
            this.SceneObject = SceneObject;
        }

        public static class SceneObjectBean {
            /**
             * SceneID : 650100000011900000010220171219100515999830556499
             * InfoKind : 1
             * SourceID : 66000000001190123456022017120110101000008
             * DeviceID : 55000111221190000007
             * BeginTime : 19981230010000
             * PlaceType : 1100
             * WeatherType : 05
             * SceneDescribe : 天气良好
             * SceneType : 11
             * RoadAlignmentType : 11
             * RoadTerrainType : 1
             * RoadSurfaceType : 1
             * RoadCoditionType : 1
             * RoadJunctionSectionType : 11
             * RoadLightingType : 1
             * Illustration : 1
             * WindDirection : 东南
             * Illumination : 1
             * FieldCondition : 1
             * Temperature : 25
             * Humidity : 1
             * PopulationDensity : 1
             * DenseDegree : 1
             * Importance : 4
             * SubImageList : {"SubImageInfoObject":[{"ImageID":"33020300001190000001022017122111111100321","EventSort":4,"DeviceID":"55220299011190000253","StoragePath":"http://localhost:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg","Type":"14","FileFormat":"Jpeg","ShotTime":"20170925032455","Width":437,"Height":350}]}
             */

            private String SceneID;
            private int InfoKind;
            private String SourceID;
            private String DeviceID;
            private String BeginTime;
            private String PlaceType;
            private String WeatherType;
            private String SceneDescribe;
            private String SceneType;
            private String RoadAlignmentType;
            private int RoadTerrainType;
            private String RoadSurfaceType;
            private String RoadCoditionType;
            private String RoadJunctionSectionType;
            private String RoadLightingType;
            private String Illustration;
            private String WindDirection;
            private String Illumination;
            private String FieldCondition;
            private int Temperature;
            private String Humidity;
            private String PopulationDensity;
            private String DenseDegree;
            private int Importance;
            private SubImageListBean SubImageList;

            public String getSceneID() {
                return SceneID;
            }

            public void setSceneID(String SceneID) {
                this.SceneID = SceneID;
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

            public String getBeginTime() {
                return BeginTime;
            }

            public void setBeginTime(String BeginTime) {
                this.BeginTime = BeginTime;
            }

            public String getPlaceType() {
                return PlaceType;
            }

            public void setPlaceType(String PlaceType) {
                this.PlaceType = PlaceType;
            }

            public String getWeatherType() {
                return WeatherType;
            }

            public void setWeatherType(String WeatherType) {
                this.WeatherType = WeatherType;
            }

            public String getSceneDescribe() {
                return SceneDescribe;
            }

            public void setSceneDescribe(String SceneDescribe) {
                this.SceneDescribe = SceneDescribe;
            }

            public String getSceneType() {
                return SceneType;
            }

            public void setSceneType(String SceneType) {
                this.SceneType = SceneType;
            }

            public String getRoadAlignmentType() {
                return RoadAlignmentType;
            }

            public void setRoadAlignmentType(String RoadAlignmentType) {
                this.RoadAlignmentType = RoadAlignmentType;
            }

            public int getRoadTerrainType() {
                return RoadTerrainType;
            }

            public void setRoadTerrainType(int RoadTerrainType) {
                this.RoadTerrainType = RoadTerrainType;
            }

            public String getRoadSurfaceType() {
                return RoadSurfaceType;
            }

            public void setRoadSurfaceType(String RoadSurfaceType) {
                this.RoadSurfaceType = RoadSurfaceType;
            }

            public String getRoadCoditionType() {
                return RoadCoditionType;
            }

            public void setRoadCoditionType(String RoadCoditionType) {
                this.RoadCoditionType = RoadCoditionType;
            }

            public String getRoadJunctionSectionType() {
                return RoadJunctionSectionType;
            }

            public void setRoadJunctionSectionType(String RoadJunctionSectionType) {
                this.RoadJunctionSectionType = RoadJunctionSectionType;
            }

            public String getRoadLightingType() {
                return RoadLightingType;
            }

            public void setRoadLightingType(String RoadLightingType) {
                this.RoadLightingType = RoadLightingType;
            }

            public String getIllustration() {
                return Illustration;
            }

            public void setIllustration(String Illustration) {
                this.Illustration = Illustration;
            }

            public String getWindDirection() {
                return WindDirection;
            }

            public void setWindDirection(String WindDirection) {
                this.WindDirection = WindDirection;
            }

            public String getIllumination() {
                return Illumination;
            }

            public void setIllumination(String Illumination) {
                this.Illumination = Illumination;
            }

            public String getFieldCondition() {
                return FieldCondition;
            }

            public void setFieldCondition(String FieldCondition) {
                this.FieldCondition = FieldCondition;
            }

            public int getTemperature() {
                return Temperature;
            }

            public void setTemperature(int Temperature) {
                this.Temperature = Temperature;
            }

            public String getHumidity() {
                return Humidity;
            }

            public void setHumidity(String Humidity) {
                this.Humidity = Humidity;
            }

            public String getPopulationDensity() {
                return PopulationDensity;
            }

            public void setPopulationDensity(String PopulationDensity) {
                this.PopulationDensity = PopulationDensity;
            }

            public String getDenseDegree() {
                return DenseDegree;
            }

            public void setDenseDegree(String DenseDegree) {
                this.DenseDegree = DenseDegree;
            }

            public int getImportance() {
                return Importance;
            }

            public void setImportance(int Importance) {
                this.Importance = Importance;
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
                     * ImageID : 33020300001190000001022017122111111100321
                     * EventSort : 4
                     * DeviceID : 55220299011190000253
                     * StoragePath : http://localhost:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg
                     * Type : 14
                     * FileFormat : Jpeg
                     * ShotTime : 20170925032455
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
