import React, {useState} from 'react'
import { Link } from 'react-router-dom';
import { Breadcrumb, Pagination, Table, Input, Button, Steps, Upload } from 'element-react';

const Caseform = () => {
  const [formData, setFormData] = useState({
    casename: '', 
    caseid: '', 
    courtname: '', 
    publish: '', 
    keywords: '', 
    abstract: '', 
    conflictfocus: '', 
    judgepoint: '', 
    lawcase: '', 
    recres: '', 
    article: ''
  });

  const { casename, caseid, courtname, publish, keywords, abstract, conflictfocus, judgepoint, lawcase, recres, article } = formData;

  const onChange = (e) =>
    setFormData({ ...formData, [e.target.name]: e.target.value });

  return (
    <div style={{padding: "1rem"}}>
      <div style={{}}>
        <Breadcrumb separator="/" >
          <Breadcrumb.Item>首页</Breadcrumb.Item>
          <Breadcrumb.Item>案例众筹</Breadcrumb.Item>
          <Breadcrumb.Item>众筹新增</Breadcrumb.Item>
        </Breadcrumb>
        
        <Steps space={200} active={2} style={{display: 'flex', justifyContent: 'center'}}>
          <Steps.Step title="步骤 1"></Steps.Step>
          <Steps.Step title="步骤 2"></Steps.Step>
        </Steps>

        <p style={{color: 'white', display: 'flex', justifyContent: 'center'}}>将案例的简略内容进行填写；第二步，审查系统自动匹配的相关案例要素是否正确；第三步，提交通过审核后获取1个月的免费使用时长。</p>
      </div>

      <div style={{backgroundColor: 'rgb(26,30,35)', padding: '1rem'}}>

        <div style={{display: 'flex', justifyContent: 'center', alignItems: 'center', margin: '1rem'}}>
          <form
            className="form"
            onSubmit={(e) => {
              e.preventDefault();
              submitCase(formData).then(() => navigate('/'));
            }}
          >
            <p style={{ color: 'white' }}>【基本信息】</p>
              <span>案件名称</span><input
                type="text"
                name="title"
                value={casename}
                onChange={onChange}
                required
              />
              <span>案号</span><input
                type="text"
                name="caseid"
                value={caseid}
                onChange={onChange}
                required
              />
              <span>审理法院信息</span><input
                type="text"
                name="courtname"
                value={courtname}
                onChange={onChange}
                required
              />
              <span>发布机关</span><input
                type="text"
                name="publish"
                value={publish}
                onChange={onChange}
                required
              />
            <p style={{ color: 'white' }}>【关键词】</p>
            <div className="form-group">
              <input
                type="text"
                name="keywords"
                value={keywords}
                onChange={onChange}
                required
              />
            </div>
            <p style={{ color: 'white' }}>【案情摘要】</p>
            <div className="form-group">
              <textarea
                name="abstract"
                cols="30"
                rows="5"
                value={abstract}
                onChange={onChange}
              />
            </div>
            <p style={{ color: 'white' }}>【争议焦点】</p>
            <div className="form-group">
              <textarea
                name="conflictfocus"
                cols="30"
                rows="5"
                value={conflictfocus}
                onChange={onChange}
              />
            </div>
            <p style={{ color: 'white' }}>【裁判要点】</p>
            <div className="form-group">
              <textarea
                name="judgepoint"
                cols="30"
                rows="5"
                value={judgepoint}
                onChange={onChange}
              />
            </div>
            <p style={{ color: 'white' }}>【适用法律】</p>
            <div className="form-group">
              <textarea
                name="lawcase"
                cols="30"
                rows="5"
                value={lawcase}
                onChange={onChange}
              />
            </div>
            <p style={{ color: 'white' }}>【推荐理由】</p>
            <div className="form-group">
              <textarea
                name="recres"
                cols="30"
                rows="5"
                value={recres}
                onChange={onChange}
              />
            </div>
            <p style={{ color: 'white' }}>【生效文书】</p>
            <div className="form-group">
              <textarea
                name="article"
                cols="30"
                rows="5"
                value={article}
                onChange={onChange}
              />
            </div>
          </form>
        </div>

        <div style={{display: 'flex', justifyContent: 'center', alignItems: 'center', margin: '2rem'}}>
          <Button><Link to="/fill">上一步</Link></Button>
          <Button type="primary"><Link to="/">提交</Link></Button>
        </div>
      </div>

      <div>
          <p style={{ color: 'white' }}>说明</p>

          <p style={{ color: 'white' }}>众筹范围</p>
          <p style={{ color: 'white' }}>编写案例分析所依据的裁判文书应当为已经在中国裁判文书网公开的裁判文书，原则上应当为2020、2021年度的生效裁判，特别具有典型意义的2019年度生效裁判文书也可作为编写来源。
              未审结的案件不能作为编写来源。</p>

          <p style={{ color: 'white' }}>内容要求</p>
          <p style={{ color: 'white' }}>案例分析文章正文由“标题”、“副标题”、“关键词”、“裁判要旨”、“相关法条”、“案件索引”、“基本案情”、“裁判结果”、“裁判理由”、“案例注解”等部分组成。</p>
          <p style={{ color: 'white' }}>案例注解部分应当重点围绕案件具有指导意义的争议焦点或者分歧意见，充分阐明案例在适用法律解决争议焦点过程中，创造性解释、揭示或阐明新的法律适用规则方面的理念、方法和典型意义。
          具体内容一般包括但不限于：裁判要旨所涉及的法律、司法解释内容和知识；本案所解决的法律争点问题；裁判的思路和方法；本案例的指导意义；类似案例及关联；本案例参照适用中应当注意的问题等。
          分析应当说理充分、严谨、精炼、透彻，用语规范、逻辑严谨，充分揭示案例体现的裁判规则、理念和方法，对类似案件的裁判具有指导、参考和启示意义，展现人民法院的司法智慧和司法成果。
          鼓励分析新型、疑难案件，特别是对各领域中的立法、司法解释制定有参考借鉴价值的案例。</p>
      </div>
    </div>
  )
}

export default Caseform
