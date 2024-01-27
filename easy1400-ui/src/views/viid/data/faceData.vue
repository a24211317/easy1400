<template>
  <div class="app-container">
    <div>
      <el-row :gutter="0">
        <el-form
          ref="elForm"
          :model="formData"
          :rules="rules"
          size="medium"
          label-width="auto"
          label-position="left"
        >
          <el-col :span="4"> </el-col>
          <el-col :span="5">
            <el-form-item label="设备ID" prop="deviceId">
              <el-input
                v-model="formData.deviceId"
                clearable
                :style="{ width: '99%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="人脸ID" prop="faceID">
              <el-input
                v-model="formData.faceID"
                clearable
                :style="{ width: '99%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="时间范围" prop="timeArr">
              <el-date-picker
                @change="changeQueryTime($event)"
                type="datetimerange"
                v-model="timeArr"
                is-range
                format="yyyy-MM-dd HH:mm:ss"
                value-format="yyyy-MM-dd HH:mm:ss"
                :style="{ width: '95%' }"
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
          :span="6"
          v-for="face in faceDataList"
          :key="face.faceID"
          class="face-data-col"
          ><div class="grid-content bg-purple">
            <div
              v-for="imgObj in face.SubImageList.SubImageInfoObject"
              :key="imgObj.ImageID"
            >
              <el-image
                class="face_img"
                v-if="imgObj.Type == 14"
                :src="imgObj.StoragePath"
              />
            </div>
            <div :style="{ padding: '2%' }">
              <el-row :gutter="5">
                <el-col :span="16"
                  ><span class="face-data-col-text"
                    >抓拍时间: {{ parseDataTime(face.FaceAppearTime) }}
                  </span></el-col
                >
              </el-row>
              <el-row :gutter="5">
                <el-col :span="24"
                  ><span class="face-data-col-text"
                    >设备编号: {{ face.DeviceID }}</span
                  ></el-col
                >
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
        :page-size="8"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
import { getFacePage } from "@/api/viid/data/faceData";
import { getToken } from "@/utils/auth";

export default {
  name: "faceData",
  data() {
    return {
      faceDataList: [],
      formData: {
        page: 1,
        rows: 8,
        deviceId: "",
        faceID: "",
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
    this.getFacePage();
  },
  mounted() {},
  methods: {
    parseDataTime(time) {
      return (
        time.substr(0, 4) +
        "-" +
        time.substr(4, 2) +
        "-" +
        time.substr(6, 2) +
        " " +
        time.substr(8, 2) +
        ":" +
        time.substr(10, 2) +
        ":" +
        time.substr(12, 2)
      );
    },
    changeQueryTime(val) {
      this.formData.beginTime = val[0];
      this.formData.endTime = val[1];
    },
    getFacePage() {
      var _this = this;
      getFacePage(this.formData).then((response) => {
        console.log(response.data);
        var data = response.data;
        _this.dataTotal = data.total;
        console.log(data.records);
        _this.faceDataList = data.records;
      });
    },
    submitForm() {
      var _this = this;
      this.$refs["elForm"].validate((valid) => {
        if (!valid) return;
        //  提交表单
        _this.getFacePage();
      });
    },
    //当前页改变时触发 跳转其他页
    handleCurrentChange(val) {
      this.formData.page = val;
      this.getFacePage();
    },
  },
};
</script>
<style>
.face-data-col-text {
  white-space: nowrap;
  text-overflow: ellipsis;
  overflow: hidden;
  width: 100%;
  display: block;
}
.face_img {
  margin: 1%;
  width: 98%;
  height: 18rem;
}
.face-data-col {
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
.el-image__error {
}
</style>