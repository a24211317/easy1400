<template>
  <div class="app-container">
    <div style="margin-left: 2rem; margin-right: 2rem">
      <el-collapse accordion @change="colChange">
        <el-collapse-item
          v-for="platform in viidCascadePlatformList"
          :key="platform.systemID"
          :title="platform.name"
          :name="platform.systemID"
        >
          <div>
            <el-descriptions class="margin-top" :column="2" border>
              <el-descriptions-item>
                <template slot="label"> 系统编码 </template>
                {{ platform.systemID }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 系统名称 </template>
                {{ platform.name }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 系统IP </template>
                {{ platform.ipaddr }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 系统端口 </template>
                {{ platform.port }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 用户名 </template>
                {{ platform.userId }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 密码 </template>
                {{ platform.password }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 状态 </template>
                {{ platform.isOnline ==0 ?'离线' :'在线' }}
              </el-descriptions-item>
              <!-- <el-descriptions-item>
                <template slot="label"> 开关 </template>
                {{ platform.systemID }}
              </el-descriptions-item> -->
            </el-descriptions>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>
  </div>
</template>

<script>
import { getViidCascadePlatforms } from "@/api/viid/system/viidCascadePlatform";
import { getToken } from "@/utils/auth";

export default {
  name: "viidCascadePlatform",
  data() {
    return {
      viidCascadePlatformList: [],
      clickID: "",
    };
  },
  computed: {},
  watch: {},
  created() {
    this.getViidCascadePlatforms();
  },
  mounted() {},
  methods: {
    getViidCascadePlatforms() {
      var _this = this;
      getViidCascadePlatforms(_this.$route.query.type).then((response) => {
        _this.viidCascadePlatformList = response.data;
      });
    },
    colChange(val) {
      this.clickID = val;
    },
  },
};
</script>
<style>
.el-collapse-item__header {
  padding: 2rem;
}
.el-collapse-item__header.is-active {
  background: #01a3b0;
}
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