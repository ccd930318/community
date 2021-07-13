package community.community.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import community.community.dto.TagDTO;

public class TagCache {
    public static List<TagDTO> get() {
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("一般商城");
        program.setTags(Arrays.asList("全新商品", "會員相關"));
        tagDTOS.add(program);

        TagDTO framework = new TagDTO();
        framework.setCategoryName("二手商城");
        framework.setTags(Arrays.asList("二手商品", "賣家", "商品問題"));
        tagDTOS.add(framework);


        TagDTO server = new TagDTO();
        server.setCategoryName("拍賣");
        server.setTags(Arrays.asList("拍賣商品", "拍賣問題", "拍賣數量", "拍賣時間", "拍賣商品內容"));
        tagDTOS.add(server);

        TagDTO db = new TagDTO();
        db.setCategoryName("競標");
        db.setTags(Arrays.asList("競標商品", "競標規則", "競標時間", "競標金額", "競標問題"));
        tagDTOS.add(db);

        TagDTO tool = new TagDTO();
        tool.setCategoryName("其他");
        tool.setTags(Arrays.asList("閒聊", "抱怨", "分享", "開箱", "心得", "討論"));
        tagDTOS.add(tool);
        return tagDTOS;
    }

    public static String filterInvalid(String tags) {
        String[] split = StringUtils.split(tags, ",");
        List<TagDTO> tagDTOS = get();

        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> StringUtils.isBlank(t) || !tagList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }

    public static void main(String[] args) {
        int i = (5 - 1) >>> 1;
        System.out.println(i);
    }
}
