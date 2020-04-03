package com.hepeng.baselibrary.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class ChatListBean implements MultiItemEntity {
    private String id;//记录id
    private String adviceid;//会话ID
    private String orderno;//会话订单号
    private String typecode;//消息类型：0-系统消息，1-系统说明消息，2-聊天消息。0如问诊单处方等，1系统补充说明消息,2聊天消息
    private String sendtype;//发送类型 0-医生发送,1-就诊人发送
    private String doctorid;//医生id
    private String patientid;//就诊人id
    private String msgtype;//消息类型
    private String seetype;//可见类型(0-全部可见,1-医生可见,2-患者可见)
    private String content;//聊天内容
    private String ext;//云通讯扩展字段存储
    private String createtime;//时间
    private ExtBean extBean;
    private String status = "success";

    @Override
    public int getItemType() {
        int type = 1;
        switch (extBean.getType()) {
            case "txt":
                if (sendtype.equals("0")) {//医生发送
                    type = 1;
                } else {//患者发送
                    type = 2;
                }
                break;
            case "img":
                if (sendtype.equals("0")) {//医生发送
                    type = 3;
                } else {//患者发送
                    type = 4;
                }
                break;
            case "audio":
                if (sendtype.equals("0")) {//医生发送
                    type = 5;
                } else {//患者发送
                    type = 6;
                }
                break;
            case "pres"://药方
                type = 7;
                break;
            case "evaluate"://邀请评价
            case "inquiry"://问诊单
            case "visit"://坐诊信息
            case "reg"://挂号信息
                if (msgtype.equals("system")) {
                    type = 9;
                } else {
                    type = 8;
                }
                break;
            case "system":
                type = 9;
                break;
        }
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdviceid() {
        return adviceid;
    }

    public void setAdviceid(String adviceid) {
        this.adviceid = adviceid;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getSendtype() {
        return sendtype;
    }

    public void setSendtype(String sendtype) {
        this.sendtype = sendtype;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getSeetype() {
        return seetype;
    }

    public void setSeetype(String seetype) {
        this.seetype = seetype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public ExtBean getExtBean() {
        if (extBean == null) {
            return new ExtBean();
        }
        return extBean;
    }

    public void setExtBean(ExtBean extBean) {
        this.extBean = extBean;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ExtBean {
        private String type = "";
        private String ID = "";//问诊单id
        private String text = "";
        private ImgBean ImgBean;
        private AudioBean AudioBean;
        private PresBean PresBean;


        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public ImgBean getImgBean() {
            if (ImgBean == null) {
                return new ImgBean();
            }
            return ImgBean;
        }

        public void setImgBean(ImgBean imgBean) {
            this.ImgBean = imgBean;
        }

        public AudioBean getAudioBean() {
            if (AudioBean == null) {
                return new AudioBean();
            }
            return AudioBean;
        }

        public void setAudioBean(AudioBean audioBean) {
            this.AudioBean = audioBean;
        }

        public PresBean getPresBean() {
            if (PresBean == null) {
                return new PresBean();
            }
            return PresBean;
        }

        public void setPresBean(PresBean presBean) {
            this.PresBean = presBean;
        }

        public static class ImgBean {
            private String imgurl = "";
            private int width;
            private int height;

            public String getImgurl() {
                return imgurl;
            }

            public void setImgurl(String imgurl) {
                this.imgurl = imgurl;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }

        public static class AudioBean {

            /**
             * filename : 201808/D84AD95DC236A28A7CBFC607ECFD81D9
             * seconds : 2
             * secret :
             * url : 201808/D84AD95DC236A28A7CBFC607ECFD81D9
             */

            private String filename = "";
            private int seconds;
            private String secret = "";
            private String url = "";

            public String getFilename() {
                return filename;
            }

            public void setFilename(String filename) {
                this.filename = filename;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public String getSecret() {
                return secret;
            }

            public void setSecret(String secret) {
                this.secret = secret;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class PresBean {
            private String id = "";
            private String presName = "";
            private String patName = "";
            private String patSex = "";
            private String patAge = "";
            private String diagnose = "";
            private String time = "";

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPresName() {
                return presName;
            }

            public void setPresName(String presName) {
                this.presName = presName;
            }

            public String getPatName() {
                return patName == null ? "" : patName;
            }

            public void setPatName(String patName) {
                this.patName = patName;
            }

            public String getPatSex() {
                return patSex == null ? "" : patSex;
            }

            public void setPatSex(String patSex) {
                this.patSex = patSex;
            }

            public String getPatAge() {
                return patAge == null ? "" : patAge;
            }

            public void setPatAge(String patAge) {
                this.patAge = patAge;
            }

            public String getPatientinfo() {
                return patName + "（" +
                        (patSex.equals("0") ? "男" : "女") +
                        " " + patAge + "岁）";
            }

            public String getDiagnose() {
                return diagnose;
            }

            public void setDiagnose(String diagnose) {
                this.diagnose = diagnose;
            }
        }
    }
}
