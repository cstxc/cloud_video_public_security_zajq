package com.zjxc.video.etldata.beanObject;
/*
 *@ClassName  CaseListObjectClass
 *@description    TODO
 *@author     Whoami
 *@date   2020/7/27
 *@version 1.0
 */


import java.util.List;

public class CaseListObjectClass {

    /**
     * CaseListObject : {"Case":[{"CaseInfo":{"CaseID":"330101000001201711231000000008","CaseName":"偷窥未遂","CaseAbstract":"凌晨欲偷窥，因天色太暗，未能成功","ClueID":"33020300001190000001022017122121111100001","TimeUpLimit":"20171122104649","CreateTime":"20171123104653","PlaceCode":"330102","PlaceFullAddress":"dahua研发","MotorVehicleIDs":"","NonMotorVehicleIDs":"","PersonIDs":"","FaceIDs":"","ThingIDs":"","SceneIDs":"","State":2},"PersonList":{},"FaceList":{},"MotorVehicleList":{},"NonMotorVehicleList":{},"ThingList":{},"SceneList":{},"FileList":{"File":[{"FileInfo":{"FileID":"33020300001190000001032017122111111100001","InfoKind":1,"Source":"99","FileName":"测试","StoragePath":"http://10.33.6.108:8080/d/file.txt","FileHash":"jksj","FileFormat":"txt","Title":"测试标题","EntryTime":"20160523145849","FileSize":20480},"Data":"${carNumPicBase64}"}]}}]}
     */

    private CaseListObjectBean CaseListObject;

    public CaseListObjectBean getCaseListObject() {
        return CaseListObject;
    }

    public void setCaseListObject(CaseListObjectBean CaseListObject) {
        this.CaseListObject = CaseListObject;
    }

    public static class CaseListObjectBean {
        private List<CaseBean> Case;

        public List<CaseBean> getCase() {
            return Case;
        }

        public void setCase(List<CaseBean> Case) {
            this.Case = Case;
        }

        public static class CaseBean {
            /**
             * CaseInfo : {"CaseID":"330101000001201711231000000008","CaseName":"偷窥未遂","CaseAbstract":"凌晨欲偷窥，因天色太暗，未能成功","ClueID":"33020300001190000001022017122121111100001","TimeUpLimit":"20171122104649","CreateTime":"20171123104653","PlaceCode":"330102","PlaceFullAddress":"dahua研发","MotorVehicleIDs":"","NonMotorVehicleIDs":"","PersonIDs":"","FaceIDs":"","ThingIDs":"","SceneIDs":"","State":2}
             * PersonList : {}
             * FaceList : {}
             * MotorVehicleList : {}
             * NonMotorVehicleList : {}
             * ThingList : {}
             * SceneList : {}
             * FileList : {"File":[{"FileInfo":{"FileID":"33020300001190000001032017122111111100001","InfoKind":1,"Source":"99","FileName":"测试","StoragePath":"http://10.33.6.108:8080/d/file.txt","FileHash":"jksj","FileFormat":"txt","Title":"测试标题","EntryTime":"20160523145849","FileSize":20480},"Data":"${carNumPicBase64}"}]}
             */

            private CaseInfoBean CaseInfo;
            private PersonListBean PersonList;
            private FaceListBean FaceList;
            private MotorVehicleListBean MotorVehicleList;
            private NonMotorVehicleListBean NonMotorVehicleList;
            private ThingListBean ThingList;
            private SceneListBean SceneList;
            private FileListBean FileList;

            public CaseInfoBean getCaseInfo() {
                return CaseInfo;
            }

            public void setCaseInfo(CaseInfoBean CaseInfo) {
                this.CaseInfo = CaseInfo;
            }

            public PersonListBean getPersonList() {
                return PersonList;
            }

            public void setPersonList(PersonListBean PersonList) {
                this.PersonList = PersonList;
            }

            public FaceListBean getFaceList() {
                return FaceList;
            }

            public void setFaceList(FaceListBean FaceList) {
                this.FaceList = FaceList;
            }

            public MotorVehicleListBean getMotorVehicleList() {
                return MotorVehicleList;
            }

            public void setMotorVehicleList(MotorVehicleListBean MotorVehicleList) {
                this.MotorVehicleList = MotorVehicleList;
            }

            public NonMotorVehicleListBean getNonMotorVehicleList() {
                return NonMotorVehicleList;
            }

            public void setNonMotorVehicleList(NonMotorVehicleListBean NonMotorVehicleList) {
                this.NonMotorVehicleList = NonMotorVehicleList;
            }

            public ThingListBean getThingList() {
                return ThingList;
            }

            public void setThingList(ThingListBean ThingList) {
                this.ThingList = ThingList;
            }

            public SceneListBean getSceneList() {
                return SceneList;
            }

            public void setSceneList(SceneListBean SceneList) {
                this.SceneList = SceneList;
            }

            public FileListBean getFileList() {
                return FileList;
            }

            public void setFileList(FileListBean FileList) {
                this.FileList = FileList;
            }

            public static class CaseInfoBean {
                /**
                 * CaseID : 330101000001201711231000000008
                 * CaseName : 偷窥未遂
                 * CaseAbstract : 凌晨欲偷窥，因天色太暗，未能成功
                 * ClueID : 33020300001190000001022017122121111100001
                 * TimeUpLimit : 20171122104649
                 * CreateTime : 20171123104653
                 * PlaceCode : 330102
                 * PlaceFullAddress : dahua研发
                 * MotorVehicleIDs :
                 * NonMotorVehicleIDs :
                 * PersonIDs :
                 * FaceIDs :
                 * ThingIDs :
                 * SceneIDs :
                 * State : 2
                 */

                private String CaseID;
                private String CaseName;
                private String CaseAbstract;
                private String ClueID;
                private String TimeUpLimit;
                private String CreateTime;
                private String PlaceCode;
                private String PlaceFullAddress;
                private String MotorVehicleIDs;
                private String NonMotorVehicleIDs;
                private String PersonIDs;
                private String FaceIDs;
                private String ThingIDs;
                private String SceneIDs;
                private int State;

                public String getCaseID() {
                    return CaseID;
                }

                public void setCaseID(String CaseID) {
                    this.CaseID = CaseID;
                }

                public String getCaseName() {
                    return CaseName;
                }

                public void setCaseName(String CaseName) {
                    this.CaseName = CaseName;
                }

                public String getCaseAbstract() {
                    return CaseAbstract;
                }

                public void setCaseAbstract(String CaseAbstract) {
                    this.CaseAbstract = CaseAbstract;
                }

                public String getClueID() {
                    return ClueID;
                }

                public void setClueID(String ClueID) {
                    this.ClueID = ClueID;
                }

                public String getTimeUpLimit() {
                    return TimeUpLimit;
                }

                public void setTimeUpLimit(String TimeUpLimit) {
                    this.TimeUpLimit = TimeUpLimit;
                }

                public String getCreateTime() {
                    return CreateTime;
                }

                public void setCreateTime(String CreateTime) {
                    this.CreateTime = CreateTime;
                }

                public String getPlaceCode() {
                    return PlaceCode;
                }

                public void setPlaceCode(String PlaceCode) {
                    this.PlaceCode = PlaceCode;
                }

                public String getPlaceFullAddress() {
                    return PlaceFullAddress;
                }

                public void setPlaceFullAddress(String PlaceFullAddress) {
                    this.PlaceFullAddress = PlaceFullAddress;
                }

                public String getMotorVehicleIDs() {
                    return MotorVehicleIDs;
                }

                public void setMotorVehicleIDs(String MotorVehicleIDs) {
                    this.MotorVehicleIDs = MotorVehicleIDs;
                }

                public String getNonMotorVehicleIDs() {
                    return NonMotorVehicleIDs;
                }

                public void setNonMotorVehicleIDs(String NonMotorVehicleIDs) {
                    this.NonMotorVehicleIDs = NonMotorVehicleIDs;
                }

                public String getPersonIDs() {
                    return PersonIDs;
                }

                public void setPersonIDs(String PersonIDs) {
                    this.PersonIDs = PersonIDs;
                }

                public String getFaceIDs() {
                    return FaceIDs;
                }

                public void setFaceIDs(String FaceIDs) {
                    this.FaceIDs = FaceIDs;
                }

                public String getThingIDs() {
                    return ThingIDs;
                }

                public void setThingIDs(String ThingIDs) {
                    this.ThingIDs = ThingIDs;
                }

                public String getSceneIDs() {
                    return SceneIDs;
                }

                public void setSceneIDs(String SceneIDs) {
                    this.SceneIDs = SceneIDs;
                }

                public int getState() {
                    return State;
                }

                public void setState(int State) {
                    this.State = State;
                }
            }

            public static class PersonListBean {
            }

            public static class FaceListBean {
            }

            public static class MotorVehicleListBean {
            }

            public static class NonMotorVehicleListBean {
            }

            public static class ThingListBean {
            }

            public static class SceneListBean {
            }

            public static class FileListBean {
                private List<FileBean> File;

                public List<FileBean> getFile() {
                    return File;
                }

                public void setFile(List<FileBean> File) {
                    this.File = File;
                }

                public static class FileBean {
                    /**
                     * FileInfo : {"FileID":"33020300001190000001032017122111111100001","InfoKind":1,"Source":"99","FileName":"测试","StoragePath":"http://10.33.6.108:8080/d/file.txt","FileHash":"jksj","FileFormat":"txt","Title":"测试标题","EntryTime":"20160523145849","FileSize":20480}
                     * Data : ${carNumPicBase64}
                     */

                    private FileInfoBean FileInfo;
                    private String Data;

                    public FileInfoBean getFileInfo() {
                        return FileInfo;
                    }

                    public void setFileInfo(FileInfoBean FileInfo) {
                        this.FileInfo = FileInfo;
                    }

                    public String getData() {
                        return Data;
                    }

                    public void setData(String Data) {
                        this.Data = Data;
                    }

                    public static class FileInfoBean {
                        /**
                         * FileID : 33020300001190000001032017122111111100001
                         * InfoKind : 1
                         * Source : 99
                         * FileName : 测试
                         * StoragePath : http://10.33.6.108:8080/d/file.txt
                         * FileHash : jksj
                         * FileFormat : txt
                         * Title : 测试标题
                         * EntryTime : 20160523145849
                         * FileSize : 20480
                         */

                        private String FileID;
                        private int InfoKind;
                        private String Source;
                        private String FileName;
                        private String StoragePath;
                        private String FileHash;
                        private String FileFormat;
                        private String Title;
                        private String EntryTime;
                        private int FileSize;

                        public String getFileID() {
                            return FileID;
                        }

                        public void setFileID(String FileID) {
                            this.FileID = FileID;
                        }

                        public int getInfoKind() {
                            return InfoKind;
                        }

                        public void setInfoKind(int InfoKind) {
                            this.InfoKind = InfoKind;
                        }

                        public String getSource() {
                            return Source;
                        }

                        public void setSource(String Source) {
                            this.Source = Source;
                        }

                        public String getFileName() {
                            return FileName;
                        }

                        public void setFileName(String FileName) {
                            this.FileName = FileName;
                        }

                        public String getStoragePath() {
                            return StoragePath;
                        }

                        public void setStoragePath(String StoragePath) {
                            this.StoragePath = StoragePath;
                        }

                        public String getFileHash() {
                            return FileHash;
                        }

                        public void setFileHash(String FileHash) {
                            this.FileHash = FileHash;
                        }

                        public String getFileFormat() {
                            return FileFormat;
                        }

                        public void setFileFormat(String FileFormat) {
                            this.FileFormat = FileFormat;
                        }

                        public String getTitle() {
                            return Title;
                        }

                        public void setTitle(String Title) {
                            this.Title = Title;
                        }

                        public String getEntryTime() {
                            return EntryTime;
                        }

                        public void setEntryTime(String EntryTime) {
                            this.EntryTime = EntryTime;
                        }

                        public int getFileSize() {
                            return FileSize;
                        }

                        public void setFileSize(int FileSize) {
                            this.FileSize = FileSize;
                        }
                    }
                }
            }
        }
    }
}
