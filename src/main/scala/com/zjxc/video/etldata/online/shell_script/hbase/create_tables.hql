
create 'CaseListMessagePooldb', 'info', SPLITS => ['0','1', '2', '3', '4','5', '6', '7', '8','9']

CREATE INDEX IF NOT EXISTS "idx_CaseListMessagePooldb_row"  ON "CaseListMessagePooldb"("row");

drop table  "CaseListMessagePooldb";
create table  "CaseListMessagePooldb" (
"row"  varchar primary key,
"info"."CaseID" varchar,
"info"."CaseName" varchar,
"info"."CaseAbstract" varchar,
"info"."ClueID" varchar,
"info"."TimeUpLimit" varchar,
"info"."CreateTime" varchar,
"info"."PlaceCode" varchar,
"info"."PlaceFullAddress" varchar,
"info"."MotorVehicleIDs" varchar,
"info"."NonMotorVehicleIDs" varchar,
"info"."PersonIDs" varchar,
"info"."FaceIDs" varchar,
"info"."ThingIDs" varchar,
"info"."SceneIDs" varchar,
"info"."State" varchar,
"info"."FileInfoFileID" varchar,
"info"."FileInfoInfoKind" varchar,
"info"."FileInfoSource" varchar,
"info"."FileInfoFileName" varchar,
"info"."FileInfoStoragePath" varchar,
"info"."FileInfoFileHash" varchar,
"info"."FileInfoFileFormat" varchar,
"info"."FileInfoTitle" varchar,
"info"."FileInfoEntryTime" varchar,
"info"."FileInfoFileSize" varchar,
"info"."JSONMessage" varchar
)
column_encoded_bytes=0
;



----------------------------------


create 'VideoSliceListMessagePooldb', 'info', SPLITS => ['0','1', '2', '3', '4','5', '6', '7', '8','9']

CREATE INDEX IF NOT EXISTS "idx_VideoSliceListMessagePooldb_row"  ON "VideoSliceListMessagePooldb"("row");

drop table  "VideoSliceListMessagePooldb";
create table  "VideoSliceListMessagePooldb" (
"row"  varchar primary key,
"info"."VideoID" varchar,
"info"."InfoKind" varchar,
"info"."VideoSource" varchar,
"info"."FileHash" varchar,
"info"."FileFormat" varchar,
"info"."CodedFormat" varchar,
"info"."AudioFlag" varchar,
"info"."Title" varchar,
"info"."ContentDescription" varchar,
"info"."ShotPlaceCode" varchar,
"info"."VideoLen" varchar,
"info"."BeginTime" varchar,
"info"."EndTime" varchar,
"info"."StoragePath" varchar,
"info"."ThumbnailStoragePath" varchar,
"info"."ShotPlaceFullAdress" varchar,
"info"."ShotPlaceLongitude" varchar,
"info"."ShotPlaceLatitude" varchar,
"info"."EntryClerkOrg" varchar,
"info"."EntryTime" varchar,
"info"."FileSize" varchar,
"info"."JSONMessage" varchar
)
column_encoded_bytes=0
;



----------------------------------

create 'FileListMessagePooldb', 'info', SPLITS => ['0','1', '2', '3', '4','5', '6', '7', '8','9']

CREATE INDEX IF NOT EXISTS "idx_FileListMessagePooldb_row"  ON "FileListMessagePooldb"("row");

drop table  "FileListMessagePooldb";
create table  "FileListMessagePooldb" (
"row"  varchar primary key,
"info"."FileID" varchar,
"info"."InfoKind" varchar,
"info"."Source" varchar,
"info"."FileName" varchar,
"info"."StoragePath" varchar,
"info"."FileHash" varchar,
"info"."FileFormat" varchar,
"info"."Title" varchar,
"info"."EntryTime" varchar,
"info"."FileSize" varchar,
"info"."JSONMessage" varchar
)
column_encoded_bytes=0
;



----------------------------------
create 'SceneListMessagePooldb', 'info', SPLITS => ['0','1', '2', '3', '4','5', '6', '7', '8','9']

CREATE INDEX IF NOT EXISTS "idx_SceneListMessagePooldb_row"  ON "SceneListMessagePooldb"("row");

drop table  "SceneListMessagePooldb";
create table  "SceneListMessagePooldb" (
"row"  varchar primary key,
"info"."SceneID" varchar,
"info"."InfoKind" varchar,
"info"."SourceID" varchar,
"info"."DeviceID" varchar,
"info"."BeginTime" varchar,
"info"."PlaceType" varchar,
"info"."WeatherType" varchar,
"info"."SceneDescribe" varchar,
"info"."SceneType" varchar,
"info"."RoadAlignmentType" varchar,
"info"."RoadTerrainType" varchar,
"info"."RoadSurfaceType" varchar,
"info"."RoadCoditionType" varchar,
"info"."RoadJunctionSectionType" varchar,
"info"."RoadLightingType" varchar,
"info"."Illustration" varchar,
"info"."WindDirection" varchar,
"info"."Illumination" varchar,
"info"."FieldCondition" varchar,
"info"."Temperature" varchar,
"info"."Humidity" varchar,
"info"."PopulationDensity" varchar,
"info"."DenseDegree" varchar,
"info"."Importance" varchar,
"info"."ImageInfoImageID" varchar,
"info"."ImageInfoEventSort" varchar,
"info"."ImageInfoDeviceID" varchar,
"info"."ImageInfoStoragePath" varchar,
"info"."ImageInfoType" varchar,
"info"."ImageInfoFileFormat" varchar,
"info"."ImageInfoShotTime" varchar,
"info"."ImageInfoWidth" varchar,
"info"."ImageInfoHeight" varchar,
"info"."JSONMessage" varchar
)
column_encoded_bytes=0
;



----------------------------------
create 'ThingListMessagePooldb', 'info', SPLITS => ['0','1', '2', '3', '4','5', '6', '7', '8','9']

CREATE INDEX IF NOT EXISTS "idx_ThingListMessagePooldb_row"  ON "ThingListMessagePooldb"("row");

drop table  "ThingListMessagePooldb";
create table  "ThingListMessagePooldb" (
"row"  varchar primary key,
"info"."ThingID" varchar,
"info"."InfoKind" varchar,
"info"."SourceID" varchar,
"info"."DeviceID" varchar,
"info"."LeftTopX" varchar,
"info"."LeftTopY" varchar,
"info"."RightBtmX" varchar,
"info"."RightBtmY" varchar,
"info"."LocationMarkTime" varchar,
"info"."AppearTime" varchar,
"info"."DisappearTime" varchar,
"info"."Name" varchar,
"info"."Shape" varchar,
"info"."Color" varchar,
"info"."Size" varchar,
"info"."Material" varchar,
"info"."Characteristic" varchar,
"info"."Propertiy" varchar,
"info"."InvolvedObjType" varchar,
"info"."FirearmsAmmunitionType" varchar,
"info"."ToolTraceType" varchar,
"info"."EvidenceType" varchar,
"info"."CaseEvidenceType" varchar,
"info"."ImageInfoImageID" varchar,
"info"."ImageInfoEventSort" varchar,
"info"."ImageInfoDeviceID" varchar,
"info"."ImageInfoStoragePath" varchar,
"info"."ImageInfoType" varchar,
"info"."ImageInfoFileFormat" varchar,
"info"."ImageInfoShotTime" varchar,
"info"."ImageInfoWidth" varchar,
"info"."ImageInfoHeight" varchar,
"info"."JSONMessage" varchar
)
column_encoded_bytes=0
;



----------------------------------

create 'NonMotorVehicleListMessagePooldb', 'info', SPLITS => ['0','1', '2', '3', '4','5', '6', '7', '8','9']

CREATE INDEX IF NOT EXISTS "idx_NonMotorVehicleListMessagePooldb_row"  ON "NonMotorVehicleListMessagePooldb"("row");

drop table  "NonMotorVehicleListMessagePooldb";
create table  "NonMotorVehicleListMessagePooldb" (
"row"  varchar primary key,
"info"."NonMotorVehicleID" varchar,
"info"."InfoKind" varchar,
"info"."SourceID" varchar,
"info"."DeviceID" varchar,
"info"."LeftTopX" varchar,
"info"."LeftTopY" varchar,
"info"."RightBtmX" varchar,
"info"."RightBtmY" varchar,
"info"."HasPlate" varchar,
"info"."PlateClass" varchar,
"info"."PlateColor" varchar,
"info"."PlateNo" varchar,
"info"."PlateNoAttach" varchar,
"info"."PlateDescribe" varchar,
"info"."IsDecked" varchar,
"info"."IsAltered" varchar,
"info"."IsCovered" varchar,
"info"."DrivingStatusCode" varchar,
"info"."UsingPropertiesCode" varchar,
"info"."VehicleBrand" varchar,
"info"."VehicleType" varchar,
"info"."VehicleLength" varchar,
"info"."VehicleWidth" varchar,
"info"."VehicleHeight" varchar,
"info"."VehicleColor" varchar,
"info"."VehicleHood" varchar,
"info"."VehicleTrunk" varchar,
"info"."VehicleWheel" varchar,
"info"."WheelPrintedPattern" varchar,
"info"."VehicleWindow" varchar,
"info"."VehicleRoof" varchar,
"info"."VehicleDoor" varchar,
"info"."SideOfVehicle" varchar,
"info"."CarOfVehicle" varchar,
"info"."RearviewMirror" varchar,
"info"."VehicleChassis" varchar,
"info"."VehicleShielding" varchar,
"info"."FilmColor" varchar,
"info"."ImageInfoImageID" varchar,
"info"."ImageInfoEventSort" varchar,
"info"."ImageInfoDeviceID" varchar,
"info"."ImageInfoStoragePath" varchar,
"info"."ImageInfoType" varchar,
"info"."ImageInfoFileFormat" varchar,
"info"."ImageInfoShotTime" varchar,
"info"."ImageInfoWidth" varchar,
"info"."ImageInfoHeight" varchar,
"info"."JSONMessage" varchar
)
column_encoded_bytes=0
;



----------------------------------
create 'MotorVehicleListMessagePooldb', 'info', SPLITS => ['0','1', '2', '3', '4','5', '6', '7', '8','9']

CREATE INDEX IF NOT EXISTS "idx_MotorVehicleListMessagePooldb_row"  ON "MotorVehicleListMessagePooldb"("row");

drop table  "MotorVehicleListMessagePooldb";
create table  "MotorVehicleListMessagePooldb" (
"row"  varchar primary key,
"info"."MotorVehicleID" varchar,
"info"."InfoKind" varchar,
"info"."SourceID" varchar,
"info"."TollgateID" varchar,
"info"."DeviceID" varchar,
"info"."StorageUrl1" varchar,
"info"."StorageUrl3" varchar,
"info"."StorageUrl5" varchar,
"info"."LeftTopX" varchar,
"info"."LeftTopY" varchar,
"info"."RightBtmX" varchar,
"info"."RightBtmY" varchar,
"info"."LaneNo" varchar,
"info"."HasPlate" varchar,
"info"."PlateClass" varchar,
"info"."PlateColor" varchar,
"info"."PlateNo" varchar,
"info"."PlateNoAttach" varchar,
"info"."PlateDescribe" varchar,
"info"."IsDecked" varchar,
"info"."IsAltered" varchar,
"info"."IsCovered" varchar,
"info"."Speed" varchar,
"info"."Direction" varchar,
"info"."DrivingStatusCode" varchar,
"info"."UsingPropertiesCode" varchar,
"info"."VehicleClass" varchar,
"info"."VehicleBrand" varchar,
"info"."VehicleModel" varchar,
"info"."VehicleStyles" varchar,
"info"."VehicleLength" varchar,
"info"."VehicleWidth" varchar,
"info"."VehicleHeight" varchar,
"info"."VehicleColor" varchar,
"info"."VehicleColorDepth" varchar,
"info"."VehicleHood" varchar,
"info"."VehicleTrunk" varchar,
"info"."VehicleWheel" varchar,
"info"."WheelPrintedPattern" varchar,
"info"."VehicleWindow" varchar,
"info"."VehicleRoof" varchar,
"info"."VehicleDoor" varchar,
"info"."SideOfVehicle" varchar,
"info"."CarOfVehicle" varchar,
"info"."RearviewMirror" varchar,
"info"."VehicleChassis" varchar,
"info"."VehicleShielding" varchar,
"info"."FilmColor" varchar,
"info"."IsModified" varchar,
"info"."HitMarkInfo" varchar,
"info"."VehicleBodyDesc" varchar,
"info"."VehicleFrontItem" varchar,
"info"."DescOfFrontItem" varchar,
"info"."VehicleRearItem" varchar,
"info"."DescOfRearItem" varchar,
"info"."NumOfPassenger" varchar,
"info"."PassTime" varchar,
"info"."NameOfPassedRoad" varchar,
"info"."IsSuspicious" varchar,
"info"."PlateReliability" varchar,
"info"."PlateCharReliability" varchar,
"info"."BrandReliability" varchar,
"info"."ImageInfoImageID" varchar,
"info"."ImageInfoEventSort" varchar,
"info"."ImageInfoDeviceID" varchar,
"info"."ImageInfoStoragePath" varchar,
"info"."ImageInfoType" varchar,
"info"."ImageInfoFileFormat" varchar,
"info"."ImageInfoShotTime" varchar,
"info"."ImageInfoWidth" varchar,
"info"."ImageInfoHeight" varchar,
"info"."JSONMessage" varchar
)
column_encoded_bytes=0
;


----------------------------------




create 'faceListMessagePooldb', 'info', SPLITS => ['0','1', '2', '3', '4','5', '6', '7', '8','9']

CREATE INDEX IF NOT EXISTS "idx_faceListMessagePooldb_row"  ON "faceListMessagePooldb"("row");

drop table  "faceListMessagePooldb";
create table  "faceListMessagePooldb" (
"row"  varchar primary key,
"info"."FaceID" varchar,
"info"."InfoKind" varchar,
"info"."SourceID" varchar,
"info"."DeviceID" varchar,
"info"."LeftTopX" varchar,
"info"."LeftTopY" varchar,
"info"."RightBtmX" varchar,
"info"."RightBtmY" varchar,
"info"."LocationMarkTime" varchar,
"info"."FaceAppearTime" varchar,
"info"."FaceDisAppearTime" varchar,
"info"."IDType" varchar,
"info"."IDNumber" varchar,
"info"."Name" varchar,
"info"."UsedName" varchar,
"info"."Alias" varchar,
"info"."GenderCode" varchar,
"info"."AgeUpLimit" varchar,
"info"."AgeLowerLimit" varchar,
"info"."EthicCode" varchar,
"info"."NationalityCode" varchar,
"info"."NativeCityCode" varchar,
"info"."ResidenceAdminDivision" varchar,
"info"."ChineseAccentCode" varchar,
"info"."JobCategory" varchar,
"info"."AccompanyNumber" varchar,
"info"."SkinColor" varchar,
"info"."HairStyle" varchar,
"info"."HairColor" varchar,
"info"."FaceStyle" varchar,
"info"."FacialFeature" varchar,
"info"."PhysicalFeature" varchar,
"info"."RespiratorColor" varchar,
"info"."CapStyle" varchar,
"info"."CapColor" varchar,
"info"."GlassStyle" varchar,
"info"."GlassColor" varchar,
"info"."IsDriver" varchar,
"info"."IsForeigner" varchar,
"info"."PassportType" varchar,
"info"."ImmigrantTypeCode" varchar,
"info"."IsSuspectedTerrorist" varchar,
"info"."SuspectedTerroristNumber" varchar,
"info"."IsCriminalInvolved" varchar,
"info"."CriminalInvolvedSpecilisationCode" varchar,
"info"."BodySpeciallMark" varchar,
"info"."CrimeMethod" varchar,
"info"."CrimeCharacterCode" varchar,
"info"."EscapedCriminalNumber" varchar,
"info"."IsDetainees" varchar,
"info"."DetentionHouseCode" varchar,
"info"."DetaineesIdentity" varchar,
"info"."DetaineesSpecialIdentity" varchar,
"info"."MemberTypeCode" varchar,
"info"."IsVictim" varchar,
"info"."VictimType" varchar,
"info"."InjuredDegree" varchar,
"info"."CorpseConditionCode" varchar,
"info"."IsSuspiciousPerson" varchar,
"info"."Attitude" varchar,
"info"."Similaritydegree" varchar,
"info"."EyebrowStyle" varchar,
"info"."NoseStyle" varchar,
"info"."MustacheStyle" varchar,
"info"."LipStyle" varchar,
"info"."WrinklePouch" varchar,
"info"."AcneStain" varchar,
"info"."FreckleBirthmark" varchar,
"info"."ScarDimple" varchar,
"info"."OtherFeature" varchar,
"info"."ImageInfoImageID" varchar,
"info"."ImageInfoEventSort" varchar,
"info"."ImageInfoDeviceID" varchar,
"info"."ImageInfoStoragePath" varchar,
"info"."ImageInfoType" varchar,
"info"."ImageInfoFileFormat" varchar,
"info"."ImageInfoShotTime" varchar,
"info"."ImageInfoWidth" varchar,
"info"."ImageInfoHeight" varchar,
"info"."JSONMessage" varchar
)
column_encoded_bytes=0
;

----------------------------------
create 'imageListMessagePooldb', 'info', SPLITS => ['0','1', '2', '3', '4','5', '6', '7', '8','9']

CREATE INDEX IF NOT EXISTS "idx_imageListMessagePooldb_row"  ON "imageListMessagePooldb"("row");

drop table  "imageListMessagePooldb";
create table  "imageListMessagePooldb" (
"row"  varchar primary key,
"info"."ImageID" varchar,
"info"."InfoKind" varchar,
"info"."ImageSource" varchar,
"info"."EventSort" varchar,
"info"."StoragePath" varchar,
"info"."ShotTime" varchar,
"info"."ShotPlaceFullAdress" varchar,
"info"."ShotPlaceLongitude" varchar,
"info"."ShotPlaceLatitude" varchar,
"info"."EntryClerkOrg" varchar,
"info"."EntryTime" varchar,
"info"."FileHash" varchar,
"info"."FileFormat" varchar,
"info"."Title" varchar,
"info"."ContentDescription" varchar,
"info"."Width" varchar,
"info"."Height" varchar,
"info"."SecurityLevel" varchar,
"info"."FileSize" varchar,
"info"."JSONMessage" varchar
)
column_encoded_bytes=0
;

----------------------------------

create 'personListMessagePooldb', 'info', SPLITS => ['0','1', '2', '3', '4','5', '6', '7', '8','9']

CREATE INDEX IF NOT EXISTS "idx_personListMessagePooldb_row"  ON "personListMessagePooldb"("row");

drop table  "personListMessagePooldb";
create table  "personListMessagePooldb" (
"row"  varchar primary key,
"info"."PersonID" varchar,
"info"."InfoKind" varchar,
"info"."SourceID" varchar,
"info"."DeviceID" varchar,
"info"."LeftTopX" varchar,
"info"."LeftTopY" varchar,
"info"."RightBtmX" varchar,
"info"."RightBtmY" varchar,
"info"."LocationMarkTime" varchar,
"info"."PersonAppearTime" varchar,
"info"."PersonDisAppearTime" varchar,
"info"."IDType" varchar,
"info"."IDNumber" varchar,
"info"."Name" varchar,
"info"."UsedName" varchar,
"info"."Alias" varchar,
"info"."GenderCode" varchar,
"info"."AgeUpLimit" varchar,
"info"."AgeLowerLimit" varchar,
"info"."EthicCode" varchar,
"info"."NationalityCode" varchar,
"info"."NativeCityCode" varchar,
"info"."ResidenceAdminDivision" varchar,
"info"."ChineseAccentCode" varchar,
"info"."PersonOrg" varchar,
"info"."JobCategory" varchar,
"info"."AccompanyNumber" varchar,
"info"."HeightUpLimit" varchar,
"info"."HeightLowerLimit" varchar,
"info"."BodyType" varchar,
"info"."SkinColor" varchar,
"info"."HairStyle" varchar,
"info"."HairColor" varchar,
"info"."Gesture" varchar,
"info"."Status" varchar,
"info"."FaceStyle" varchar,
"info"."FacialFeature" varchar,
"info"."PhysicalFeature" varchar,
"info"."BodyFeature" varchar,
"info"."HabitualMovement" varchar,
"info"."Behavior" varchar,
"info"."BehaviorDescription" varchar,
"info"."Appendant" varchar,
"info"."AppendantDescription" varchar,
"info"."UmbrellaColor" varchar,
"info"."RespiratorColor" varchar,
"info"."CapStyle" varchar,
"info"."CapColor" varchar,
"info"."GlassStyle" varchar,
"info"."GlassColor" varchar,
"info"."ScarfColor" varchar,
"info"."BagStyle" varchar,
"info"."BagColor" varchar,
"info"."CoatStyle" varchar,
"info"."CoatLength" varchar,
"info"."CoatColor" varchar,
"info"."TrousersStyle" varchar,
"info"."TrousersColor" varchar,
"info"."TrousersLen" varchar,
"info"."ShoesStyle" varchar,
"info"."ShoesColor" varchar,
"info"."IsDriver" varchar,
"info"."IsForeigner" varchar,
"info"."PassportType" varchar,
"info"."ImmigrantTypeCode" varchar,
"info"."IsSuspectedTerrorist" varchar,
"info"."SuspectedTerroristNumber" varchar,
"info"."IsCriminalInvolved" varchar,
"info"."CriminalInvolvedSpecilisationCode" varchar,
"info"."BodySpeciallMark" varchar,
"info"."CrimeMethod" varchar,
"info"."CrimeCharacterCode" varchar,
"info"."EscapedCriminalNumber" varchar,
"info"."IsDetainees" varchar,
"info"."DetentionHouseCode" varchar,
"info"."DetaineesIdentity" varchar,
"info"."DetaineesSpecialIdentity" varchar,
"info"."MemberTypeCode" varchar,
"info"."IsVictim" varchar,
"info"."VictimType" varchar,
"info"."InjuredDegree" varchar,
"info"."CorpseConditionCode" varchar,
"info"."IsSuspiciousPerson" varchar,
"info"."SubImageInfoImageID" varchar,
"info"."SubImageInfoEventSort" varchar,
"info"."SubImageInfoDeviceID" varchar,
"info"."SubImageInfoStoragePath" varchar,
"info"."SubImageInfoType" varchar,
"info"."SubImageInfoFileFormat" varchar,
"info"."SubImageInfoShotTime" varchar,
"info"."SubImageInfoWidth" varchar,
"info"."SubImageInfoHeight" varchar,
"info"."JSONMessage" varchar
)
column_encoded_bytes=0
;


----------------------------------

CREATE TABLE IF NOT EXISTS MASSAGE_COUNT (
     MASSAGENAME VARCHAR NOT NULL,
     DATESTR VARCHAR NOT NULL,
     COUNT BIGINT,
     CONSTRAINT PK PRIMARY KEY (MASSAGENAME, DATESTR)
);


----------------------------------

CREATE TABLE IF NOT EXISTS MASSAGE_DEVICE_COUNT (
     DATESTR VARCHAR NOT NULL,
     DEVICEID VARCHAR NOT NULL,
     COUNT BIGINT,
     CONSTRAINT PK PRIMARY KEY (DATESTR, DEVICEID)
);