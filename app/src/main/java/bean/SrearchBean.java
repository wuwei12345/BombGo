package bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuwei on 2016/10/28.
 */

public class SrearchBean implements Serializable{

    /**
     * data : [{"document_id":30929,"display_type":1,"title":"听说有这么一档节目，让张全蛋抛弃李小花爱上了呼啦星","image":"http://ww4.sinaimg.cn/large/005OouL3jw1f61p7h40vij30hs0hsabf.jpg","thumbnail":"http://ww1.sinaimg.cn/large/005OpvXrjw1f61p7h9n5aj30hs0hsabf.jpg","author_avatar":"http://ww1.sinaimg.cn/large/0062aae5jw1ewj4ajql7ij30dw0dwtb3.jpg","author_name":"王尼玛","share_image":"","key_words":"王尼玛   听说有这么一档节目，让张全蛋抛弃李小花爱上了呼啦星   大爷来玩儿","video_image_url":"","guide":"小鲜肉，萌妹，御姐","author_id":498123,"section_id":81,"display_date":"07 月 21 日","ga_prefix":"072117","share_url":"http://baozouribao.com/documents/30929","url":"http://dailyapi.ibaozou.com/api/v31/documents/30929","hit_count":24816,"section_name":"大爷来玩儿","section_image":"http://ww1.sinaimg.cn/small/0060idrsjw1ewkb7aq88ej30f00a0wf7.jpg","section_color":"FF9999","hit_count_string":"2.48万","timestamp":1469633421,"comment_count":33,"vote_count":105,"author_summary":"操操操操操操操操操操操操操操操操操操操操","original_tag":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/05/1462853591015-b0edhpbqpf4lp02n4qk1b-21ee5b7a6e5b4c9bb2c2335a0bbb62dd"},{"document_id":29757,"display_type":1,"title":"辣条生产环境遭曝光，张全蛋带你揭秘辣条的真相","image":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/07/1468162042284-r6w1mtxrl062iiokh8l5zp-704a5b9c02bcd606c5544c6f7ee2806a","thumbnail":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/07/1468028705747-h3hz617ltvc2hvd5i4h096-682b4b7404c43280c38ea662e9f48ad6","author_avatar":"http://ww1.sinaimg.cn/large/0062aae5jw1ewj4ajql7ij30dw0dwtb3.jpg","author_name":"王尼玛","share_image":"","key_words":"王尼玛【毁三观】辣条生产环境遭曝光 节操新闻播报","video_image_url":"","guide":"","guide_image":"","author_id":498123,"section_id":81,"display_date":"07 月 10 日","ga_prefix":"071020","share_url":"http://baozouribao.com/documents/29757","url":"http://dailyapi.ibaozou.com/api/v31/documents/29757","hit_count":59163,"section_name":"大爷来玩儿","section_image":"http://ww1.sinaimg.cn/small/0060idrsjw1ewkb7aq88ej30f00a0wf7.jpg","section_color":"FF9999","hit_count_string":"5.92万","timestamp":1468162056,"comment_count":262,"vote_count":599,"author_summary":"操操操操操操操操操操操操操操操操操操操操","original_tag":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/05/1462853591015-b0edhpbqpf4lp02n4qk1b-21ee5b7a6e5b4c9bb2c2335a0bbb62dd"},{"document_id":29680,"display_type":1,"title":"《吐槽大会》：一个随时随地就能污起来的节目","image":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/07/1467949581027-sddscbqszn315zema6tvy-1f73e84eb49c6e6a26fc1a93e9901218","thumbnail":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/07/1467949473821-c5dpxh27nvcr05oc77jcp-1f73e84eb49c6e6a26fc1a93e9901218","author_avatar":"http://ww3.sinaimg.cn/mw1024/005HAbgEjw1f0ytl4gb8oj30c80c8myw.jpg","author_name":"香菜君","share_image":"","key_words":"香菜君 《吐槽大会》：《吐槽大会》：一个随时随地就能污起来的节目 香菜聊综艺","video_image_url":"","guide":"","guide_image":"","author_id":616768,"section_id":223,"display_date":"07 月 08 日","ga_prefix":"070819","share_url":"http://baozouribao.com/documents/29680","url":"http://dailyapi.ibaozou.com/api/v31/documents/29680","hit_count":44130,"section_name":"香菜聊综艺","section_image":"http://ww2.sinaimg.cn/small/005HAbgEjw1f1xcburoegj30f00a0dil.jpg","section_color":"7CD095","hit_count_string":"4.41万","timestamp":1467982663,"comment_count":132,"vote_count":375,"author_summary":"有时候很\u201c愤青\u201d。","original_tag":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/05/1462853591015-b0edhpbqpf4lp02n4qk1b-21ee5b7a6e5b4c9bb2c2335a0bbb62dd"},{"document_id":27992,"display_type":1,"title":"魅蓝公然发番号要发车？竟然还请了女优去直播！","image":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/06/1465848977589-1wul9pd2w47b8pvvdzofzw-f4ccc0c74d87ebcc8e1313828b965a6f","thumbnail":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/06/1465848977556-94ptoz9sbomo6trrlmxt4c-f4ccc0c74d87ebcc8e1313828b965a6f","author_avatar":"http://ww4.sinaimg.cn/large/a63ba0fbjw1f11dqssj2ij208c0830ta.jpg","author_name":"攻城狮","share_image":"","key_words":"攻城狮 魅蓝公然发番号要发车？竟然还请了女优去直播！ 野生技术控","video_image_url":"","guide":"","guide_image":"","author_id":641026,"section_id":198,"display_date":"06 月 13 日","ga_prefix":"061318","share_url":"http://baozouribao.com/documents/27992","url":"http://dailyapi.ibaozou.com/api/v31/documents/27992","hit_count":55866,"section_name":"野生技术控","section_image":"http://ww3.sinaimg.cn/small/a63ba0fbjw1ez9i7iol7sj20f00a0myt.jpg","section_color":"FF9999","hit_count_string":"5.59万","timestamp":1465817578,"comment_count":118,"vote_count":212,"author_summary":"编辑界的攻城狮，科技界的污妖王~@野生技术控","original_tag":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/05/1462853591015-b0edhpbqpf4lp02n4qk1b-21ee5b7a6e5b4c9bb2c2335a0bbb62dd"},{"document_id":27834,"display_type":1,"title":"大事件幕后，独家揭秘，远赴韩国拍摄花絮！","image":"http://ww2.sinaimg.cn/large/005RXLu5jw1f4rhm25q99j30hs0et76k.jpg","thumbnail":"http://ww1.sinaimg.cn/large/005O1Z1njw1f4rhm3jgh7j303c03c0sx.jpg","author_avatar":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2015/11/1448331562320-r5il7qyan5lbe1sc2bxvl-f8cf8290abad4935f6a6c30b9bca0297","author_name":"小怪","share_image":"","key_words":"小怪 大事件幕后，独家揭秘，远赴韩国拍摄花絮！ 直击暴走大事件","video_image_url":"","guide":"","guide_image":"","author_id":561984,"section_id":49,"display_date":"06 月 11 日","ga_prefix":"061119","share_url":"http://baozouribao.com/documents/27834","url":"http://dailyapi.ibaozou.com/api/v31/documents/27834","hit_count":32379,"section_name":"直击暴走大事件","section_image":"http://ww2.sinaimg.cn/small/005ZZu0ujw1ewkbivmf17j30f00a0ab3.jpg","section_color":"80CFCA","hit_count_string":"3.24万","timestamp":1465655185,"comment_count":92,"vote_count":180,"author_summary":"","original_tag":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/05/1462853591015-b0edhpbqpf4lp02n4qk1b-21ee5b7a6e5b4c9bb2c2335a0bbb62dd"},{"document_id":27280,"display_type":1,"title":"大事件幕后花絮，啪哥闪亮登场！据说教撩妹，还包学包会？！","image":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/06/1464948591119-h2mttwfaagrddfzo17899-6c207c13614822d7d4d59d79f56a9e4c","thumbnail":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/06/1464948591114-o7qx5cynuejj7n9a4vfl-6c207c13614822d7d4d59d79f56a9e4c","author_avatar":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2015/11/1448331562320-r5il7qyan5lbe1sc2bxvl-f8cf8290abad4935f6a6c30b9bca0297","author_name":"小怪","share_image":"","key_words":"小怪 大事件幕后花絮，啪哥闪亮登场！据说教撩妹，还包学包会？！ 直击暴走大事件","video_image_url":"","guide":"","guide_image":"","author_id":561984,"section_id":49,"display_date":"06 月 05 日","ga_prefix":"060519","share_url":"http://baozouribao.com/documents/27280","url":"http://dailyapi.ibaozou.com/api/v31/documents/27280","hit_count":39708,"section_name":"直击暴走大事件","section_image":"http://ww2.sinaimg.cn/small/005ZZu0ujw1ewkbivmf17j30f00a0ab3.jpg","section_color":"80CFCA","hit_count_string":"3.97万","timestamp":1465642308,"comment_count":187,"vote_count":305,"author_summary":"","original_tag":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/05/1462853591015-b0edhpbqpf4lp02n4qk1b-21ee5b7a6e5b4c9bb2c2335a0bbb62dd"},{"document_id":21025,"display_type":1,"title":"大事件幕后花絮：金馆长&张全蛋\u2014\u2014鬼畜界表情包顺利会师！","image":"http://ww1.sinaimg.cn/large/005PbzQujw1f1ubzd4kt9j30hs0hs78p.jpg","thumbnail":"http://ww2.sinaimg.cn/large/005OoSrhjw1f1ubz8coahj303c03ct8o.jpg","author_avatar":"http://ww4.sinaimg.cn/large/005OIJpsjw1f1ubz9bs0cj30hs0hst9c.jpg","author_name":"小怪","share_image":"","key_words":"小怪 大事件幕后花絮，金馆长&张全蛋\u2014\u2014鬼畜界表情包顺利会师！ 直击暴走大事件","video_image_url":"","guide":"小怪，大事件幕后花絮，金馆长&张全蛋\u2014\u2014鬼畜界表情包顺利会师！直击暴走大事件","guide_image":"","author_id":561984,"section_id":49,"display_date":"03 月 12 日","ga_prefix":"031220","share_url":"http://baozouribao.com/documents/21025","url":"http://dailyapi.ibaozou.com/api/v31/documents/21025","hit_count":181626,"section_name":"直击暴走大事件","section_image":"http://ww2.sinaimg.cn/small/005ZZu0ujw1ewkbivmf17j30f00a0ab3.jpg","section_color":"80CFCA","hit_count_string":"18万","timestamp":1459044562,"comment_count":216,"vote_count":475,"author_summary":"","original_tag":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/05/1462853591015-b0edhpbqpf4lp02n4qk1b-21ee5b7a6e5b4c9bb2c2335a0bbb62dd"},{"document_id":21063,"display_type":1,"title":"尼玛战全蛋，来不及解释了，快上车！","image":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2016/03/1457707933912-zrabqmae5nqp5noy0o9c9d-4bc0e99360edf2d6354b88aa6c2cb7bc","thumbnail":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2016/03/1457707255251-w399k3bbwu9wwoquocx2m7-875be9e0812378496616471a5a6cc601","author_avatar":"http://ww1.sinaimg.cn/large/0062aae5jw1ewj4ajql7ij30dw0dwtb3.jpg","author_name":"王尼玛","share_image":"","key_words":"王尼玛 尼玛战全蛋，来不及解释了，快上车！ 大爷来玩儿","video_image_url":"","guide":"","guide_image":"","author_id":498123,"section_id":27,"display_date":"03 月 11 日","ga_prefix":"031122","share_url":"http://baozouribao.com/documents/21063","url":"http://dailyapi.ibaozou.com/api/v31/documents/21063","hit_count":141219,"section_name":"暴走游戏狂","section_image":"http://ww4.sinaimg.cn/small/00621QB3jw1ewkbdwpn2cj30f00a03zy.jpg","section_color":"F6C471","hit_count_string":"14万","timestamp":1459044562,"comment_count":125,"vote_count":287,"author_summary":"操操操操操操操操操操操操操操操操操操操操","original_tag":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/05/1462853591015-b0edhpbqpf4lp02n4qk1b-21ee5b7a6e5b4c9bb2c2335a0bbb62dd"},{"document_id":18204,"display_type":1,"title":"化妆改变究竟有多大？一个妹子的化妆进化史~","image":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2016/01/1453084497625-g7dgproxvlr1wi8msy0ec4-69b1f172e4f880d36209247639b7979e","thumbnail":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2016/01/1453084497628-69nt8x0uqnknonhsuen2gt-69b1f172e4f880d36209247639b7979e","author_avatar":"http://ww1.sinaimg.cn/sq612/005YDj5ijw1ey412gqxizj30h80pxjse.jpg","author_name":"蛋黄酱","share_image":"","key_words":"蛋黄酱 化妆改变究竟有多大？一个妹子的化妆进化史~ 别人家的妹子","video_image_url":"","guide":"","guide_image":"","author_id":542307,"section_id":31,"display_date":"02 月 13 日","ga_prefix":"021320","share_url":"http://baozouribao.com/documents/18204","url":"http://dailyapi.ibaozou.com/api/v31/documents/18204","hit_count":261207,"section_name":"别人家的妹子","section_image":"http://ww2.sinaimg.cn/small/0060u6Dpjw1ewkbjx6qcxj30f00a075t.jpg","section_color":"FF9999","hit_count_string":"26万","timestamp":1459044563,"comment_count":230,"vote_count":285,"author_summary":"读做妹子写做绅（hen）士（tai）其实我是小清新你们信我！","original_tag":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/05/1462853591015-b0edhpbqpf4lp02n4qk1b-21ee5b7a6e5b4c9bb2c2335a0bbb62dd"},{"document_id":18332,"display_type":1,"title":"《暴走大事件》美术指导竟然是个漂亮妹纸！","image":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2016/01/1453274666536-rs440zuaefn7h194pkhgp6-fdd424aed8305cc26a36086fe62c1631","thumbnail":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2016/01/1453274666540-s3ktdyca58ozkibvslf34p-fdd424aed8305cc26a36086fe62c1631","author_avatar":"http://ww1.sinaimg.cn/sq612/005YDj5ijw1ey412gqxizj30h80pxjse.jpg","author_name":"蛋黄酱","share_image":"","key_words":"蛋黄酱 《暴走大事件》的美术指导竟然是个漂亮妹纸！你所不知道的台前幕后~别人家的妹子","video_image_url":"","author_id":542307,"section_id":31,"display_date":"02 月 11 日","ga_prefix":"021120","share_url":"http://baozouribao.com/documents/18332","url":"http://dailyapi.ibaozou.com/api/v31/documents/18332","hit_count":358686,"section_name":"别人家的妹子","section_image":"http://ww2.sinaimg.cn/small/0060u6Dpjw1ewkbjx6qcxj30f00a075t.jpg","section_color":"FF9999","hit_count_string":"35万","timestamp":1459044563,"comment_count":455,"vote_count":958,"author_summary":"读做妹子写做绅（hen）士（tai）其实我是小清新你们信我！","original_tag":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/05/1462853591015-b0edhpbqpf4lp02n4qk1b-21ee5b7a6e5b4c9bb2c2335a0bbb62dd"},{"document_id":18702,"display_type":1,"title":"我发誓真的很棒！小清新美女摄影师和她拍的妹子们~","image":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2016/01/1454056753398-nl2v8adcrtlcpduds9x0pv-7cf5bb9aec11fcbeb7a5b8f579e580ef","thumbnail":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2016/01/1454056753404-ois0eokk2f8aqdrbz6woob-7cf5bb9aec11fcbeb7a5b8f579e580ef","author_avatar":"http://ww1.sinaimg.cn/sq612/005YDj5ijw1ey412gqxizj30h80pxjse.jpg","author_name":"蛋黄酱","share_image":"","key_words":"蛋黄酱 √我发誓真的很棒！小清新美女摄影师和她拍的妹子们~ 别人家的妹子","video_image_url":"","author_id":542307,"section_id":31,"display_date":"02 月 08 日","ga_prefix":"020821","share_url":"http://baozouribao.com/documents/18702","url":"http://dailyapi.ibaozou.com/api/v31/documents/18702","hit_count":256590,"section_name":"别人家的妹子","section_image":"http://ww2.sinaimg.cn/small/0060u6Dpjw1ewkbjx6qcxj30f00a075t.jpg","section_color":"FF9999","hit_count_string":"25万","timestamp":1459044563,"comment_count":214,"vote_count":607,"author_summary":"读做妹子写做绅（hen）士（tai）其实我是小清新你们信我！","original_tag":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/05/1462853591015-b0edhpbqpf4lp02n4qk1b-21ee5b7a6e5b4c9bb2c2335a0bbb62dd"},{"document_id":18259,"display_type":1,"title":"FB表情包大战，大陆完胜！wuli滔滔成民族英雄！","image":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2016/01/1453189055965-usyt0l3ro13uvrpc3xnm9g-2978efa8421093c6cd0a3917c1b5f2a2","thumbnail":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2016/01/1453189055958-1vwf8qlaksye1gxdizpg6z-2978efa8421093c6cd0a3917c1b5f2a2","author_avatar":"http://ww1.sinaimg.cn/large/0060idsIjw1ewj4ffcrynj30dw0dw405.jpg","author_name":"零小蝎","share_image":"","key_words":"零小蝎 FB表情包大战，大陆完胜！wuli滔滔成民族英雄！ 暴走娱乐资讯","video_image_url":"","guide":"","guide_image":"","author_id":272142,"section_id":58,"display_date":"01 月 19 日","ga_prefix":"011917","share_url":"http://baozouribao.com/documents/18259","url":"http://dailyapi.ibaozou.com/api/v31/documents/18259","hit_count":233310,"section_name":"暴走娱乐资讯","section_image":"http://ww3.sinaimg.cn/small/00621Qfrjw1ewkb8dmt0bj30f00a0q3u.jpg","section_color":"7CD095","hit_count_string":"23万","timestamp":1459044566,"comment_count":744,"vote_count":1619,"author_summary":"大写的二，天蝎座。","original_tag":"http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/05/1462853591015-b0edhpbqpf4lp02n4qk1b-21ee5b7a6e5b4c9bb2c2335a0bbb62dd"},{"document_id":17383,"display_type":1,"title":"萌萌萌！如此lo娘要是还不喜欢,你们来找我谈人生吧ಠ_ಠ ","image":"http://ww4.sinaimg.cn/large/005YbsNMjw1ezjv2ichiuj30hs0hsdie.jpg","thumbnail":"http://ww1.sinaimg.cn/large/005SZIPUjw1ezjv2itikkj303c03cjrb.jpg","author_avatar":"http://ww1.sinaimg.cn/sq612/005YDj5ijw1ey412gqxizj30h80pxjse.jpg","author_name":"蛋黄酱","share_image":"http://7o51ui.com1.z0.glb.clouddn.com/8eebb6b08c850133cd2e525400a01925.jpg","key_words":"蛋黄酱 √萌萌萌！如此lo娘要是还不喜欢,你们来找我谈人生吧ಠ_ಠ  别人家的妹子","video_image_url":"","author_id":542307,"section_id":31,"display_date":"01 月 01 日","ga_prefix":"010112","share_url":"http://baozouribao.com/documents/17383","url":"http://dailyapi.ibaozou.com/api/v31/documents/17383","hit_count":208311,"section_name":"别人家的妹子","section_image":"http://ww2.sinaimg.cn/small/0060u6Dpjw1ewkbjx6qcxj30f00a075t.jpg","section_color":"FF9999","hit_count_string":"20万","timestamp":1459044568,"comment_count":180,"vote_count":214,"author_summary":"读做妹子写做绅（hen）士（tai）其实我是小清新你们信我！"},{"document_id":16927,"display_type":1,"title":"妹子美汉子帅，分享一个性别是秀吉的coser~","image":"http://ww4.sinaimg.cn/large/005YbwCMjw1eyz3nevho4j30hs0hsn10.jpg","thumbnail":"http://ww4.sinaimg.cn/large/005ZRMxIjw1eyz3ng105wj303c03cglk.jpg","author_avatar":"http://ww1.sinaimg.cn/sq612/005YDj5ijw1ey412gqxizj30h80pxjse.jpg","author_name":"蛋黄酱","share_image":"http://7o51ui.com1.z0.glb.clouddn.com/d5514cc084a90133cd17525400a01925.jpg","key_words":"蛋黄酱 √妹子美汉子帅，分享一个性别是秀吉的coser~ 别人家的妹子","video_image_url":"","author_id":542307,"section_id":31,"display_date":"12 月 14 日","ga_prefix":"121413","share_url":"http://baozouribao.com/documents/16927","url":"http://dailyapi.ibaozou.com/api/v31/documents/16927","hit_count":181242,"section_name":"别人家的妹子","section_image":"http://ww2.sinaimg.cn/small/0060u6Dpjw1ewkbjx6qcxj30f00a075t.jpg","section_color":"FF9999","hit_count_string":"18万","timestamp":1459044570,"comment_count":308,"vote_count":117,"author_summary":"读做妹子写做绅（hen）士（tai）其实我是小清新你们信我！"},{"document_id":16941,"display_type":1,"title":"2015年年度网络流行语，你肯定都说过~","image":"http://ww2.sinaimg.cn/large/005YbKdSjw1eyuo3sxfmkj30hs0hsabq.jpg","thumbnail":"http://ww1.sinaimg.cn/large/005ZSaxVjw1eyuo3ukl6tj303c03c0so.jpg","author_avatar":"http://ww1.sinaimg.cn/small/a63ba0fbjw1eww28x0ok0j206y06ymxe.jpg","author_name":"邢捕头","share_image":"http://7o51ui.com1.z0.glb.clouddn.com/8cf6b56081860133cd0d525400a01925.jpg","key_words":"邢捕头 2015年年度网络流行语，你肯定都说过~ 暴走娱乐资讯","video_image_url":"","author_id":541364,"section_id":81,"display_date":"12 月 10 日","ga_prefix":"121017","share_url":"http://baozouribao.com/documents/16941","url":"http://dailyapi.ibaozou.com/api/v31/documents/16941","hit_count":254031,"section_name":"大爷来玩儿","section_image":"http://ww1.sinaimg.cn/small/0060idrsjw1ewkb7aq88ej30f00a0wf7.jpg","section_color":"FF9999","hit_count_string":"25万","timestamp":1459044570,"comment_count":96,"vote_count":203,"author_summary":"暴走镇衙门第一任卫衣捕头。"},{"document_id":16074,"display_type":1,"title":"全蛋张荧屏初吻，尼玛王掩盖吻痕","image":"http://ww4.sinaimg.cn/large/005YbKPrjw1exz7otfqdhj30hs0hsdkp.jpg","thumbnail":"http://ww4.sinaimg.cn/large/005Ybr7Vjw1exz7ou6t06j303c03c746.jpg","author_avatar":"http://ww1.sinaimg.cn/large/0062aae5jw1ewj4ajql7ij30dw0dwtb3.jpg","author_name":"王尼玛","share_image":"http://7o51ui.com1.z0.glb.clouddn.com/d0a1a4906c4d0133cca7525400a01925.jpg","key_words":"王尼玛 全蛋张荧屏初吻，尼玛王掩盖吻痕 直击暴走大事件","video_image_url":"http://kindeditor.b0.upaiyun.com/1447334914887393a96e78291f7ea3.jpg","author_id":498123,"section_id":49,"display_date":"11 月 13 日","ga_prefix":"111312","share_url":"http://baozouribao.com/documents/16074","url":"http://dailyapi.ibaozou.com/api/v31/documents/16074","hit_count":177741,"section_name":"直击暴走大事件","section_image":"http://ww2.sinaimg.cn/small/005ZZu0ujw1ewkbivmf17j30f00a0ab3.jpg","section_color":"80CFCA","hit_count_string":"17万","timestamp":1459044573,"comment_count":16,"vote_count":47,"author_summary":"操操操操操操操操操操操操操操操操操操操操"},{"document_id":15690,"display_type":1,"title":"暴走日报2015年十月评论之星\u2014\u2014萤火玉珏专访","image":"http://ww2.sinaimg.cn/large/005ZSI3xjw1exlmnrlycoj30hs0hs76n.jpg","thumbnail":"http://ww4.sinaimg.cn/large/005ZRKsbjw1exlmnshgowj303c03c0sk.jpg","author_avatar":"http://ww2.sinaimg.cn/large/005ZRtvijw1exmddxvodsj30jg0icgnk.jpg","author_name":"小灿","share_image":"http://7o51ui.com1.z0.glb.clouddn.com/f5ea738063a80133cc9c525400a01925.jpg","key_words":"小灿 评论之星竟然是Ta？！看一看是不是你...... ","video_image_url":"","author_id":546041,"section_id":81,"display_date":"11 月 01 日","ga_prefix":"110118","share_url":"http://baozouribao.com/documents/15690","url":"http://dailyapi.ibaozou.com/api/v31/documents/15690","hit_count":152340,"section_name":"大爷来玩儿","section_image":"http://ww1.sinaimg.cn/small/0060idrsjw1ewkb7aq88ej30f00a0wf7.jpg","section_color":"FF9999","hit_count_string":"15万","timestamp":1459044574,"comment_count":158,"vote_count":67,"author_summary":"做一个徘徊在牛A和牛C之间的人"},{"document_id":15664,"display_type":1,"title":"《脑残师兄》花絮爆料：包贝尔原来是个大暖男!","image":"http://ww4.sinaimg.cn/large/005Yat4Rjw1exi5tdmhxwj30hs0hsq4e.jpg","thumbnail":"http://ww2.sinaimg.cn/large/005ZSIhijw1exi5teiyvpj303c03cdfp.jpg","author_avatar":"http://ww3.sinaimg.cn/mw690/005G6200gw1exfr73wsioj30dw0dwdhj.jpg","author_name":"Mike Qu","share_image":"http://7o51ui.com1.z0.glb.clouddn.com/3c4a6a2060840133cc98525400a01925.jpg","key_words":"《脑残师兄》花絮爆料：包贝尔原来是个大暖男!","video_image_url":"","author_id":542272,"section_id":58,"display_date":"10 月 29 日","ga_prefix":"102918","share_url":"http://baozouribao.com/documents/15664","url":"http://dailyapi.ibaozou.com/api/v31/documents/15664","hit_count":149373,"section_name":"暴走娱乐资讯","section_image":"http://ww3.sinaimg.cn/small/00621Qfrjw1ewkb8dmt0bj30f00a0q3u.jpg","section_color":"7CD095","hit_count_string":"14万","timestamp":1459044574,"comment_count":50,"vote_count":93,"author_summary":"脑残师兄节目策划，一个曾经叱咤日报的五分美男子\r\n"},{"document_id":15391,"display_type":1,"title":"张全蛋变身张全裸，血泪控诉海鲜宰客 ","image":"http://ww2.sinaimg.cn/large/005VV2KCjw1ex2ubzrrtmj30hs0hs79m.jpg","thumbnail":"http://ww1.sinaimg.cn/large/005ZSHyqjw1ex2uc19z6oj303c03c746.jpg","author_avatar":"http://ww4.sinaimg.cn/mw690/d186e357jw1ei8ounthwuj2014014dfl.jpg","author_name":"王尼玛","share_image":"http://7o51ui.com1.z0.glb.clouddn.com/351bce70564d013383dd525400a01925.jpg","key_words":"王尼玛 张全蛋变身张全裸，血泪控诉海鲜宰客  直击暴走大事件","video_image_url":"http://kindeditor.b0.upaiyun.com/1444918925f595058bf44812dbfc98.png","section_id":49,"display_date":"10 月 16 日","ga_prefix":"101612","share_url":"http://baozouribao.com/documents/15391","url":"http://dailyapi.ibaozou.com/api/v31/documents/15391","hit_count":253800,"section_name":"直击暴走大事件","section_image":"http://ww2.sinaimg.cn/small/005ZZu0ujw1ewkbivmf17j30f00a0ab3.jpg","section_color":"80CFCA","hit_count_string":"25万","timestamp":1459044575,"comment_count":31,"vote_count":94,"author_summary":""},{"document_id":15168,"display_type":1,"title":"脑残师兄携手\u201c男神\u201d张全蛋&\u201c励志女人\u201d吴承亮陪你过国庆","image":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2015/10/1443677314477-xy1y5nrmnygkxl35t28tj-25a55cecfe666a776298e5e749db65ad","thumbnail":"http://7o51ui.com1.z0.glb.clouddn.com/ribaopic/2015/10/1443677314483-rt8qa5omrs5blmo1f3wwx-25a55cecfe666a776298e5e749db65ad!preview","author_avatar":"http://ww2.sinaimg.cn/mw690/7a08d6d1gw1emxqnb2ew0j209y09yt9n.jpg","author_name":"极品国产阿香","share_image":"http://7o51ui.com1.z0.glb.clouddn.com/f0b04e404a85013383cf525400a01925.jpg","key_words":"暴走娱乐资讯极品国产阿香脑残师兄携手\u201c男神\u201d张全蛋&\u201c励志女人\u201d吴承亮陪你过国庆脑残师兄携手男神张全蛋、励志女人吴承亮陪你过国庆","video_image_url":"","section_id":58,"display_date":"10 月 01 日","ga_prefix":"100118","share_url":"http://baozouribao.com/documents/15168","url":"http://dailyapi.ibaozou.com/api/v31/documents/15168","hit_count":449601,"section_name":"暴走娱乐资讯","section_image":"http://ww3.sinaimg.cn/small/00621Qfrjw1ewkb8dmt0bj30f00a0q3u.jpg","section_color":"7CD095","hit_count_string":"44万","timestamp":1459044576,"comment_count":92,"vote_count":153,"author_summary":""}]
     * total_pages : 3
     * per_page : 20
     * page : 1
     * total_count : 47
     */

    private int total_pages;
    private int per_page;
    private int page;
    private int total_count;
    /**
     * document_id : 30929
     * display_type : 1
     * title : 听说有这么一档节目，让张全蛋抛弃李小花爱上了呼啦星
     * image : http://ww4.sinaimg.cn/large/005OouL3jw1f61p7h40vij30hs0hsabf.jpg
     * thumbnail : http://ww1.sinaimg.cn/large/005OpvXrjw1f61p7h9n5aj30hs0hsabf.jpg
     * author_avatar : http://ww1.sinaimg.cn/large/0062aae5jw1ewj4ajql7ij30dw0dwtb3.jpg
     * author_name : 王尼玛
     * share_image :
     * key_words : 王尼玛   听说有这么一档节目，让张全蛋抛弃李小花爱上了呼啦星   大爷来玩儿
     * video_image_url :
     * guide : 小鲜肉，萌妹，御姐
     * author_id : 498123
     * section_id : 81
     * display_date : 07 月 21 日
     * ga_prefix : 072117
     * share_url : http://baozouribao.com/documents/30929
     * url : http://dailyapi.ibaozou.com/api/v31/documents/30929
     * hit_count : 24816
     * section_name : 大爷来玩儿
     * section_image : http://ww1.sinaimg.cn/small/0060idrsjw1ewkb7aq88ej30f00a0wf7.jpg
     * section_color : FF9999
     * hit_count_string : 2.48万
     * timestamp : 1469633421
     * comment_count : 33
     * vote_count : 105
     * author_summary : 操操操操操操操操操操操操操操操操操操操操
     * original_tag : http://baozouribao-qiniu.b0.upaiyun.com/ribaopic/2016/05/1462853591015-b0edhpbqpf4lp02n4qk1b-21ee5b7a6e5b4c9bb2c2335a0bbb62dd
     */

    private List<DataBean> data;

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int document_id;
        private int display_type;
        private String title;
        private String image;
        private String thumbnail;
        private String author_avatar;
        private String author_name;
        private String share_image;
        private String key_words;
        private String video_image_url;
        private String guide;
        private int author_id;
        private int section_id;
        private String display_date;
        private String ga_prefix;
        private String share_url;
        private String url;
        private int hit_count;
        private String section_name;
        private String section_image;
        private String section_color;
        private String hit_count_string;
        private int timestamp;
        private int comment_count;
        private int vote_count;
        private String author_summary;
        private String original_tag;

        public int getDocument_id() {
            return document_id;
        }

        public void setDocument_id(int document_id) {
            this.document_id = document_id;
        }

        public int getDisplay_type() {
            return display_type;
        }

        public void setDisplay_type(int display_type) {
            this.display_type = display_type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getAuthor_avatar() {
            return author_avatar;
        }

        public void setAuthor_avatar(String author_avatar) {
            this.author_avatar = author_avatar;
        }

        public String getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public String getShare_image() {
            return share_image;
        }

        public void setShare_image(String share_image) {
            this.share_image = share_image;
        }

        public String getKey_words() {
            return key_words;
        }

        public void setKey_words(String key_words) {
            this.key_words = key_words;
        }

        public String getVideo_image_url() {
            return video_image_url;
        }

        public void setVideo_image_url(String video_image_url) {
            this.video_image_url = video_image_url;
        }

        public String getGuide() {
            return guide;
        }

        public void setGuide(String guide) {
            this.guide = guide;
        }

        public int getAuthor_id() {
            return author_id;
        }

        public void setAuthor_id(int author_id) {
            this.author_id = author_id;
        }

        public int getSection_id() {
            return section_id;
        }

        public void setSection_id(int section_id) {
            this.section_id = section_id;
        }

        public String getDisplay_date() {
            return display_date;
        }

        public void setDisplay_date(String display_date) {
            this.display_date = display_date;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getHit_count() {
            return hit_count;
        }

        public void setHit_count(int hit_count) {
            this.hit_count = hit_count;
        }

        public String getSection_name() {
            return section_name;
        }

        public void setSection_name(String section_name) {
            this.section_name = section_name;
        }

        public String getSection_image() {
            return section_image;
        }

        public void setSection_image(String section_image) {
            this.section_image = section_image;
        }

        public String getSection_color() {
            return section_color;
        }

        public void setSection_color(String section_color) {
            this.section_color = section_color;
        }

        public String getHit_count_string() {
            return hit_count_string;
        }

        public void setHit_count_string(String hit_count_string) {
            this.hit_count_string = hit_count_string;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public String getAuthor_summary() {
            return author_summary;
        }

        public void setAuthor_summary(String author_summary) {
            this.author_summary = author_summary;
        }

        public String getOriginal_tag() {
            return original_tag;
        }

        public void setOriginal_tag(String original_tag) {
            this.original_tag = original_tag;
        }
    }
}
