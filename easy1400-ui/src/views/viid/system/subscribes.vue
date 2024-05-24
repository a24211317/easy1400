<template>
  <div class="app-container">
    <div>
      <el-row :gutter="12">
        <el-form
          ref="elForm"
          :model="formData"
          size="medium"
          label-width="85px"
        >
          <el-col :span="5">
            <el-form-item label="订阅类型" prop="type">
              <el-select v-model="formData.type" placeholder="请选择">
                <el-option label="全部"></el-option>
                <el-option key="0" label="订阅" value="0"></el-option>
                <el-option key="1" label="被订阅" value="1"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="3">
            <el-form-item label="平台名称" prop="name">
              <el-input
                v-model="formData.name"
                clearable
                :style="{ width: '90%' }"
              >
              </el-input>
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
        <div style="float: right">
          <el-col :span="1.5">
            <el-button
              type="primary"
              plain
              icon="el-icon-plus"
              size="medium"
              @click="
                addFormOpen = true;
                addFormTitle = `新增订阅`;
                addFormID = 0;
                addForm = {};
              "
            >新增
            </el-button
            >
          </el-col>
        </div>
      </el-row>
    </div>
    <div>
      <el-collapse v-model="activeNames" accordion @change="colChange">
        <el-collapse-item
          v-for="subscribe in viidSubscribeformList"
          :key="subscribe.id"
          :title="subscribe.Name"
          :name="subscribe.id"
        >
          <div slot="title" style="width: 100%">
            <span>{{ subscribe.SubscriberSendOrgID }} 订阅 {{ subscribe.SubscriberRecoverOrgID }}</span>
            <div style="float: right; margin-right: 30px">
              <!--               @click.stop.prevent="openCollapse()" -->
              <el-button @click="updateSubscribe(subscribe)">修改</el-button>
              <el-button @click="delSubscribe(subscribe)">删除</el-button>
            </div>
          </div>
          <div>
            <el-descriptions class="margin-top" :column="2" border>
              <el-descriptions-item>
                <template slot="label"> 订阅标识符</template>
                {{ subscribe.SubscribeID }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 订阅主题</template>
                {{ subscribe.Title }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 订阅类别</template>
                {{ subscribe.SubscribeDetail }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 订阅资源路径</template>
                {{ subscribe.ResourceURI }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 申请人</template>
                {{ subscribe.ApplicantName }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 申请单位</template>
                {{ subscribe.ApplicantOrg }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 开始时间</template>
                {{ subscribe.BeginTime }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 结束时间</template>
                {{ subscribe.EndTime }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 信息接收地址</template>
                {{ subscribe.ReceiveAddr }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 信息上报间隔时间</template>
                {{ subscribe.ReportInterval }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 理由</template>
                {{ subscribe.Reason }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 操作类型</template>
                {{ subscribe.OperateType }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 订阅执行状态</template>
                {{ subscribe.SubscribeStatus }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 订阅取消单位</template>
                {{ subscribe.SubscribeCancOrg }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 订阅取消人</template>
                {{ subscribe.SubscribeCancelPerson }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 取消时间</template>
                {{ subscribe.CancelTime }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 取消原因</template>
                {{ subscribe.CancelReason }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 订阅类型</template>
                {{ subscribe.SubscribeType }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 订阅资源类别</template>
                {{ subscribe.ResourceClass }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 审批状态</template>
                {{ subscribe.ApprovalStatus }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 审批人</template>
                {{ subscribe.ApprovalUser }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 审批时间</template>
                {{ subscribe.ApprovalTime }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 返回结果图片约定</template>
                {{ subscribe.ResultImageDeclare }}
              </el-descriptions-item>
              
              <el-descriptions-item>
                <template slot="label"> 返回结果特征值约定</template>
                {{ subscribe.ResultFeatureDeclare }}
              </el-descriptions-item>
              
              <el-descriptions-item>
                <template slot="label"> 订阅分类标签标识</template>
                {{ subscribe.TabID }}
              </el-descriptions-item>
              
              <el-descriptions-item>
                <template slot="label"> 审批时间</template>
                {{ subscribe.ApprovalTime }}
              </el-descriptions-item>
              
              <el-descriptions-item>
                <template slot="label"> 订阅发起方ID</template>
                {{ subscribe.SubscriberSendOrgID }}
              </el-descriptions-item>
              
              <el-descriptions-item>
                <template slot="label"> 被订阅方ID</template>
                {{ subscribe.SubscriberRecoverOrgID }}
              </el-descriptions-item>
            </el-descriptions>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>

    <!-- 添加或修改用户配置对话框 -->
    <el-dialog
      :title="addFormTitle"
      :visible.sync="addFormOpen"
      width="800px"
      append-to-body
    >
      <el-form
        v-if="addFormOpen"
        ref="addForm"
        :rules="addFormRules"
        :model="addForm"
        label-width="200px"
      >
        <div>
          <el-form-item label="订阅标识符" prop="SubscribeID">
            <el-input v-model="addForm.SubscribeID"></el-input>
          </el-form-item>
          <el-form-item label="订阅主题" prop="Title">
            <el-input v-model="addForm.Title"></el-input>
          </el-form-item>
          <el-form-item label="订阅类别" prop="SubscribeDetail">
            <el-input v-model="addForm.SubscribeDetail"></el-input>
          </el-form-item>
          <el-form-item label="订阅资源路径" prop="ResourceURI">
            <el-input v-model="addForm.ResourceURI"></el-input>
          </el-form-item>
          <el-form-item label="申请人" prop="ApplicantName">
            <el-input v-model="addForm.ApplicantName"></el-input>
          </el-form-item>
          <el-form-item label="申请单位" prop="ApplicantOrg">
            <el-input v-model="addForm.ApplicantOrg"></el-input>
          </el-form-item>
          <el-form-item label="开始时间" prop="BeginTime">
            <el-input v-model="addForm.BeginTime"></el-input>
          </el-form-item>
          <el-form-item label="结束时间" prop="EndTime">
            <el-input v-model="addForm.EndTime"></el-input>
          </el-form-item>
          <el-form-item label="信息接收地址" prop="ReceiveAddr">
            <el-input v-model="addForm.ReceiveAddr"></el-input>
          </el-form-item>
          <el-form-item label="信息上报间隔时间" prop="ReportInterval">
            <el-input v-model="addForm.ReportInterval"></el-input>
          </el-form-item>
          <el-form-item label="理由" prop="Reason">
            <el-input v-model="addForm.Reason"></el-input>
          </el-form-item>
          <el-form-item label="资源类别" prop="ResourceClass">
            <el-select v-model="addForm.ResourceClass" style="width: 100%">
              <el-option key="0" label="卡口" value="0"></el-option>
              <el-option key="1" label="设备" value="1"></el-option>
              <el-option key="2" label="采集内容" value="2"></el-option>
              <el-option key="3" label="案件" value="3"></el-option>
              <el-option key="4" label="视图库" value="4"></el-option>
              <el-option key="5" label="行政区划" value="5"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="返回结果图片约定" prop="ResultImageDeclare">
            <el-select v-model="addForm.ResultImageDeclare" style="width: 100%">
              <el-option key="0" label="车辆大图" value="-1"></el-option>
              <el-option key="1" label="车辆大图" value="01"></el-option>
              <el-option key="2" label="车牌彩色小图" value="02"></el-option>
              <el-option key="3" label="车牌二值化图" value="03"></el-option>
              <el-option key="4" label="驾驶员面部特征图" value="04"></el-option>
              <el-option key="5" label="副驾驶面部特征图" value="05"></el-option>
              <el-option key="6" label="车标" value="06"></el-option>
              <el-option key="7" label="违章合成图" value="07"></el-option>
              <el-option key="8" label="过车合成图" value="08"></el-option>
              <el-option key="9" label="车辆特写图" value="09"></el-option>
              <el-option key="10" label="人员图" value="10"></el-option>
              <el-option key="11" label="人脸图" value="11"></el-option>
              <el-option key="12" label="非机动车图" value="12"></el-option>
              <el-option key="13" label="物品图" value="13"></el-option>
              <el-option key="14" label="场景图" value="14"></el-option>
              <el-option key="15" label="一般图片" value="100"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="结果特征值约定" prop="ResultFeatureDeclare">
            <el-select v-model="addForm.ResultFeatureDeclare" style="width: 100%">
              <el-option key="0" label="不要特征值" value="-1"></el-option>
              <el-option key="1" label="需要返回特征值" value="1"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="订阅分类标签标识" prop="TabID">
            <el-input v-model="addForm.TabID"></el-input>
          </el-form-item>
          <el-form-item label="被订阅方ID" prop="SubscriberRecoverOrgID">
            <el-input v-model="addForm.SubscriberRecoverOrgID"></el-input>
          </el-form-item>
        </div>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addSubscribeSubmit">确 定</el-button>
        <!-- <el-button @click="cancelAdd">取 消</el-button> -->
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {getViidSubscribe,addviidSubscribeform} from "@/api/viid/system/ViidSubscribe";
import {getToken} from "@/utils/auth";

export default {
  name: "viidSubscribeform",
  data() {
    let validateIp = (rule, value, callback) => {
      if (value == "") {
        return callback(new Error("请输入IP地址"));
      } else {
        let exp =
          /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
        if (!exp.test(value)) {
          callback(new Error("请输入合法的ip"));
        } else {
          callback();
        }
        callback();
      }
    };
    let validatePort = (rule, value, callback) => {
      let reg = /^(([0-9]|[1-9]\d{1,3}|[1-5]\d{4}|6[0-5]{2}[0-3][0-5]))$/;
      if (value == "") {
        callback(new Error("请输入端口号"));
      } else if (reg.test(value) == false) {
        callback(new Error("请输入合法的端口号"));
      } else {
        callback();
      }
    };
    return {
      viidSubscribeformList: [],
      addFormOpen: false,
      clickID: "",
      activeNames: "",
      formData: {
        type: "",
        name: "",
      },
      addFormTitle: "",
      addFormID: "",

      addForm: {
        SubscribeID: "",
        Title: "",
        SubscribeDetail: "",
        ResourceURI: "",
        ApplicantName: "",
        ApplicantOrg: "",
        BeginTime: "",
        EndTime: "",
        ReceiveAddr: "",
        ReportInterval: "",
        Reason: "",
        OperateType: "0",
        SubscribeCancOrg: "",
        SubscribeCancelPerson: "",
        CancelTime: "",
        CancelReason: "",
        SubscribeType: "0",
        ResultFeatureDeclare: "",
        ResultImageDeclare: "",
      },
      addFormRules: {
        SystemID: [
          {required: true, message: "平台ID不能为空", trigger: "blur"},
          {
            min: 20,
            max: 20,
            message: "请输入正确的平台ID",
            trigger: "blur",
          },
        ],
        Name: [
          {required: true, message: "平台名称不能为空", trigger: "blur"},
        ],
        IPAddr: [{required: true, validator: validateIp, trigger: "blur"}],
        Port: [{required: true, validator: validatePort, trigger: "blur"}],
        Type: [
          {required: true, message: "平台类型不能为空", trigger: "blur"},
        ],
        Password: [
          {required: true, message: "平台密码不能为空", trigger: "blur"},
        ],
        UserId: [
          {required: true, message: "注册ID不能为空", trigger: "blur"},
        ],
      },
    };
  },
  computed: {},
  watch: {},
  stopCollapse(e) {
    return e.stopPropagation();
  },
  created() {
    this.getviidSubscribe();
  },
  mounted() {
  },
  methods: {
    getviidSubscribe() {
      var _this = this;
      getViidSubscribe(_this.formData).then((response) => {
        _this.viidSubscribeformList = response.data;
      });
    },
    colChange(val) {
      this.clickID = val;
    },
    submitForm() {
      this.getviidSubscribe();
    },
    addSubscribeSubmit() {
      var _this = this;
      this.addFormTitle = "新增订阅";
      this.$refs["addForm"].validate((valid) => {
        if (valid) {
          if (_this.addFormID == 1) {
            updateviidSubscribeform(_this.addForm).then((response) => {
              if (response.data == true) {
                _this.$modal.msgSuccess("修改成功");
                _this.addFormOpen = false;
                _this.getviidSubscribe();
              }
            });
          } else {
            _this.addForm.OperateType="0";
            _this.addForm.SubscribeType="0";
            addviidSubscribeform(_this.addForm).then((response) => {
              if(response.msg == "send error"){
                _this.$modal.msgSuccess("新增成功,订阅发送失败");
                _this.addFormOpen = false;
                _this.getviidSubscribe();
              }else if(response.msg == "save error"){
                _this.$modal.msgSuccess("新增失败，请联系管理员");
                _this.addFormOpen = false;
                _this.getviidSubscribe();
              }else {
                _this.$modal.msgSuccess("新增成功");
                _this.addFormOpen = false;
                _this.getviidSubscribe();
              }
            });
          }
        }
      });
    },
    delSubscribe(subscribe) {
      if (subscribe.Type == 2) {
        this.$modal.msgError("本级视图库禁止删除！");
      } else {
        this.$modal
          .confirm("删除不可恢复,确认删除吗？")
          .then(function () {
            return delviidSubscribeform(subscribe.id);
          })
          .then(() => {
            this.getviidSubscribe();
            this.$modal.msgSuccess("删除成功");
          })
          .catch(() => {
          });
      }
    },
    updateSubscribe(subscribe) {
      this.addFormTitle = "修改订阅";
      this.addFormID = 1;
      this.addForm.SystemID = subscribe.SystemID;
      this.addForm.Name = subscribe.Name;
      this.addForm.IPAddr = subscribe.IPAddr;
      this.addForm.Port = subscribe.Port;
      this.addForm.Type = subscribe.Type;
      this.addForm.Password = subscribe.Password;
      this.addForm.id = subscribe.id;
      this.addForm.UserId = subscribe.UserId;
      this.addFormOpen = true;
    },
  },
};
</script>
<style>
.el-collapse-item__content {
  padding: 0;
}

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
