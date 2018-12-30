package com.zyd.blog.business.vo;

import com.zyd.blog.business.entity.Article;
import com.zyd.blog.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleConditionVO extends BaseConditionVO {
	private Article article;
	private Long typeId;
	private Long tagId;
	private Integer status;
	private Boolean top;
	private Boolean recommended;
	private Boolean original;
	private Boolean random;
	private List<Long> tagIds;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getTop() {
		return top;
	}

	public void setTop(Boolean top) {
		this.top = top;
	}

	public Boolean getRecommended() {
		return recommended;
	}

	public void setRecommended(Boolean recommended) {
		this.recommended = recommended;
	}

	public Boolean getOriginal() {
		return original;
	}

	public void setOriginal(Boolean original) {
		this.original = original;
	}

	public Boolean getRandom() {
		return random;
	}

	public void setRandom(Boolean random) {
		this.random = random;
	}

	public List<Long> getTagIds() {
		return tagIds;
	}

	public void setTagIds(List<Long> tagIds) {
		this.tagIds = tagIds;
	}

	@Override
	public String toString() {
		return "ArticleConditionVO{" +
				"article=" + article +
				", typeId=" + typeId +
				", tagId=" + tagId +
				", status=" + status +
				", top=" + top +
				", recommended=" + recommended +
				", original=" + original +
				", random=" + random +
				", tagIds=" + tagIds +
				", pageNumber=" + this.getPageNumber() +
				", keywords=" + this.getKeywords() +
				'}';
	}

}

