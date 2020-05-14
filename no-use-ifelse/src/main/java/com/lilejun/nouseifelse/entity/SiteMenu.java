package com.lilejun.nouseifelse.entity;

import java.util.ArrayList;
import java.util.List;

public class SiteMenu {
    private long id;
    private String menuName;
    private String name;
    private long menuId;
    private String link;
    private long parent;
    private String description;
    private long siteId;
    private int type;
    private int order;
    private String title;
    private int target;
    private String url;
    private String configUrl;
    private int maxLevel;
    private int userType;
    private String img;

    private boolean showInPc;
    private boolean showInMobile;
    private boolean isCustomPage;

    private boolean isActive = false;
    private List<SiteMenu> subMenus = new ArrayList<>();

    private boolean oldCustomPage = false;

    private String h1Value;

    private String source;

    private int menuSource;

    private int pageTemplateId;
    private String pageTemplateName;
    private int pageTemplatePieceId;

    private int stayingFlag;
    private int threshold;
    private long stayingTime;

    //注册相关的字段 begin
    private String leadType;
    private String tags;
    private String note;
    private Boolean sendWelcomeEmail;
    private Boolean sendWelcomeTxt;
    private String assignAgent;
    private Boolean leadPrivacy;
    private int assignMethod;
    //注册相关的字段 end

    public SiteMenu() {
        //Nothing
    }

    public String getH1Value() {
        return h1Value;
    }

    public void setH1Value(String h1Value) {
        this.h1Value = h1Value;
    }

    public boolean isOldCustomPage() {
        return oldCustomPage;
    }

    public void setOldCustomPage(boolean oldCustomPage) {
        this.oldCustomPage = oldCustomPage;
    }

    public SiteMenu(long menuId, String name, long parent) {
        this.menuId = menuId;
        this.name = name;
        this.parent = parent;
    }

    public SiteMenu(long siteId, long menuId, String name, String link, long parent, int target, boolean showInPc, boolean showInMobile,
                    boolean isCustomPage) {
        this.siteId = siteId;
        this.menuId = menuId;
        this.name = name;
        this.link = link;
        this.parent = parent;
        this.target = target;
        this.showInPc = showInPc;
        this.showInMobile = showInMobile;
        this.isCustomPage = isCustomPage;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public int getType() {
        if (isShowInMobile() && isShowInPc()) {
            return 0;
        }
        if (isShowInPc()) {
            return 1;
        }
        if (isShowInMobile()) {
            return 2;
        }
        return -1;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }


    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public long getParent() {
        return parent;
    }

    public void setParent(long parent) {
        this.parent = parent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<SiteMenu> getSubMenus() {
        return subMenus;
    }

    public void addSubMenu(SiteMenu mi) {
        this.subMenus.add(mi);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getConfigUrl() {
        return configUrl;
    }

    public void setConfigUrl(String configUrl) {
        this.configUrl = configUrl;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isShowInPc() {
        return showInPc;
    }

    public void setShowInPc(boolean showInPc) {
        this.showInPc = showInPc;
    }

    public boolean isShowInMobile() {
        return showInMobile;
    }

    public void setShowInMobile(boolean showInMobile) {
        this.showInMobile = showInMobile;
    }

    public boolean isCustomPage() {
        return isCustomPage;
    }

    public void setCustomPage(boolean customPage) {
        isCustomPage = customPage;
    }

    public boolean isAddMenu(boolean isMobile) {
        return isMobile && isShowInMobile() || !isMobile && isShowInPc();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getMenuSource() {
        return menuSource;
    }

    public void setMenuSource(int menuSource) {
        this.menuSource = menuSource;
    }

    public int getPageTemplateId() {
        return pageTemplateId;
    }

    public void setPageTemplateId(int pageTemplateId) {
        this.pageTemplateId = pageTemplateId;
    }

    public String getPageTemplateName() {
        return pageTemplateName;
    }

    public void setPageTemplateName(String pageTemplateName) {
        this.pageTemplateName = pageTemplateName;
    }

    public boolean isLandingPage () {
        return this.menuSource == 2;
    }

    public int getPageTemplatePieceId() {
        return pageTemplatePieceId;
    }

    public void setPageTemplatePieceId(int pageTemplatePieceId) {
        this.pageTemplatePieceId = pageTemplatePieceId;
    }

    public int getStayingFlag() {
        return stayingFlag;
    }

    public void setStayingFlag(int stayingFlag) {
        this.stayingFlag = stayingFlag;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public long getStayingTime() {
        return stayingTime;
    }

    public void setStayingTime(long stayingTime) {
        this.stayingTime = stayingTime;
    }

    public String getLeadType() {
        return leadType;
    }

    public void setLeadType(String leadType) {
        this.leadType = leadType;
    }

    /**
     * 获取tags
     */

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getSendWelcomeEmail() {
        return sendWelcomeEmail;
    }

    public void setSendWelcomeEmail(Boolean sendWelcomeEmail) {
        this.sendWelcomeEmail = sendWelcomeEmail;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Boolean getSendWelcomeTxt() {
        return sendWelcomeTxt;
    }

    public void setSendWelcomeTxt(Boolean sendWelcomeTxt) {
        this.sendWelcomeTxt = sendWelcomeTxt;
    }

    /**
     * 根据菜单项获取菜单属于哪种页面
     */




    public String getAssignAgent() {
        return assignAgent;
    }

    public void setAssignAgent(String assignAgent) {
        this.assignAgent = assignAgent;
    }

    public Boolean getLeadPrivacy() {
        return leadPrivacy;
    }

    public void setLeadPrivacy(Boolean leadPrivacy) {
        this.leadPrivacy = leadPrivacy;
    }

    public int getAssignMethod() {
        return assignMethod;
    }

    public void setAssignMethod(int assignMethod) {
        this.assignMethod = assignMethod;
    }


}
