<template>
  <div class="app-container">
    <div>
      <el-row :gutter="0">
        <el-form
          ref="elForm"
          :model="formData"
          :rules="rules"
          size="medium"
          label-width="85px"
        >
          <el-col :span="4">
            <el-form-item label="车牌号" prop="plateNo">
              <el-input
                v-model="formData.plateNo"
                clearable
                :style="{ width: '90%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item label="设备ID" prop="deviceId">
              <el-input
                v-model="formData.deviceId"
                clearable
                :style="{ width: '90%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item label="车辆ID" prop="motorVehicleID">
              <el-input
                v-model="formData.motorVehicleID"
                clearable
                :style="{ width: '90%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="9">
            <el-form-item label="时间范围" prop="timeArr">
              <el-date-picker
                @change="changeQueryTime($event)"
                type="datetimerange"
                v-model="timeArr"
                is-range
                format="yyyy-MM-dd HH:mm:ss"
                value-format="yyyy-MM-dd HH:mm:ss"
                :style="{ width: '100%' }"
                start-placeholder="开始时间"
                end-placeholder="结束时间"
                range-separator="至"
                clearable
              ></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="1">
            <el-form-item label-width="1px">
              <el-button
                type="primary"
                icon="el-icon-search"
                size="medium"
                @click="submitForm"
              >
                查询
              </el-button>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
    </div>
    <div>
      <el-row :gutter="5">
        <el-col
          :span="8"
          v-for="motorVehicle in motorVehicleDataList"
          :key="motorVehicle.MotorVehicleID"
          class="motorVehicle-data-col"
          ><div class="grid-content bg-purple">
            <div
              v-for="imgObj in motorVehicle.SubImageList.SubImageInfoObject"
              :key="imgObj.ImageID"
            >
              <img
                class="motorVehicle_img"
                v-if="imgObj.Type == 14"
                :src="imgObj.StoragePath"
              />
            </div>
            <div :style="{padding:'2%'}">
              <el-row :gutter="5">
                <el-col :span="14">车牌号: {{motorVehicle.PlateNo}}</el-col>
                <el-col :span="10">车辆品牌: {{motorVehicle.VehicleBrand}}</el-col>
              </el-row>
              <el-row :gutter="5">
                <el-col :span="14">车牌型号:  {{motorVehicle.VehicleModel}}</el-col>
                <el-col :span="10">车辆类型:  {{motorVehicle.VehicleClass}}</el-col>
              </el-row>
              <el-row :gutter="5">
                <el-col :span="14">抓拍时间: {{parseTime(motorVehicle.PassTime)}} </el-col>
                <el-col :span="10">年款:  {{motorVehicle.VehicleStyles}}</el-col>
              </el-row>
              <el-row :gutter="5">
                <el-col :span="24">设备编号:  {{motorVehicle.DeviceID}}</el-col>
              </el-row>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
    <div class="block">
      <el-pagination
        align="center"
        @current-change="handleCurrentChange"
        layout="prev, pager, next"
        :total="dataTotal"
        :page-size="6"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
import { getMotorVehiclePage } from "@/api/viid/data/motorVehicleData";
import { getToken } from "@/utils/auth";

export default {
  name: "MotorVehicleData",
  data() {
    return {
      motorVehicleDataList: [],
      formData: {
        page: 1,
        rows: 6,
        plateNo: "",
        deviceId: "",
        motorVehicleID: "",
        beginTime: "",
        endTime: "",
      },
      dataTotal: 1,
      timeArr: [],
      rules: {
        beginTime: [
          {
            required: true,
            type: "array",
            message: "请选择开始时间",
            trigger: "change",
          },
        ],
        endTime: [
          {
            required: true,
            type: "array",
            message: "请选结束时间",
            trigger: "change",
          },
        ],
      },
    };
  },
  computed: {},
  watch: {},
  created() {
    //初始化时间
    var dd = new Date();
    var y = dd.getFullYear();
    var M = dd.getMonth() + 1; //获取当前月份的日期
    var d = dd.getDate();
    var h = dd.getHours();
    var m = dd.getMinutes();
    var s = dd.getSeconds();
    this.timeArr[0] = this.parseTime(y + "-" + M + "-" + d + " 00:00:00");
    this.timeArr[1] = this.parseTime(
      y + "-" + M + "-" + d + " " + h + ":" + m + ":" + s
    );
    this.changeQueryTime(this.timeArr);
    //查询车辆数据
    this.getMotorVehiclePage();
  },
  mounted() {},
  methods: {
    changeQueryTime(val) {
      this.formData.beginTime = val[0];
      this.formData.endTime = val[1];
    },
    getMotorVehiclePage() {
      var _this = this;
      getMotorVehiclePage(this.formData).then((response) => {
        console.log(response.data);
        var data = response.data;
        _this.dataTotal = data.total;
        _this.motorVehicleDataList = data.records;
      });
    },
    submitForm() {
      var _this = this;
      this.$refs["elForm"].validate((valid) => {
        if (!valid) return;
        //  提交表单
        _this.getMotorVehiclePage();
      });
    },
    //当前页改变时触发 跳转其他页
    handleCurrentChange(val) {
      this.formData.page = val;
      this.getMotorVehiclePage();
    },
  },
};
</script>
<style>
.motorVehicle_img {
  margin: 1%;
  width: 98%;
  height: 98%;
}
.motorVehicle-data-col {
  margin-bottom: 20px;
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  width: 100%;
  height: 100%;
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>