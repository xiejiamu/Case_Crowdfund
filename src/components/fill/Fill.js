import React, {useState} from 'react'
import { Breadcrumb, Steps, Select, Dropdown, Input, Button } from 'element-react';

const Fill = () => {    
    // 使用useState管理状态
    const [value, setValue] = useState('');
    const options = [
      { value: '选项1', label: '文本填写' },
      { value: '选项2', label: '文件上传' },
    ];
  
  return (
    <div style={{padding: "1rem"}}>
      <div style={{}}>
        <Breadcrumb separator="/" >
          <Breadcrumb.Item>首页</Breadcrumb.Item>
          <Breadcrumb.Item>案例众筹</Breadcrumb.Item>
          <Breadcrumb.Item>众筹新增</Breadcrumb.Item>
        </Breadcrumb>
        
        <Steps space={200} active={1} style={{display: 'flex', justifyContent: 'center'}}>
          <Steps.Step title="步骤 1"></Steps.Step>
          <Steps.Step title="步骤 2"></Steps.Step>
          <Steps.Step title="步骤 3"></Steps.Step>
        </Steps>

        <p style={{color: 'white', display: 'flex', justifyContent: 'center'}}>将案例的简略内容进行填写；第二步，审查系统自动匹配的相关案例要素是否正确；第三步，提交通过审核后获取1个月的免费使用时长。</p>
      </div>

      <div style={{backgroundColor: 'rgb(26,30,35)', padding: '1rem'}}>

        <div style={{display: 'flex', justifyContent: 'center', alignItems: 'center', margin: '1rem'}}>
          <span style={{color: 'white'}}>填写方式</span>
          <div style={{width: '5px'}}></div>
          <Select value={value} onChange={setValue} placeholder="文本填写">
            {options.map(el => (
              <Select.Option key={el.value} label={el.label} value={el.value} />
            ))}
          </Select>
        </div>

        <div style={{display: 'flex', justifyContent: 'center'}}>
          <span style={{color: 'white'}}>案例内容</span>
          <div style={{width: '5px'}}></div>
          <Input style={{width: '50%', height: '80%'}} type="textarea" autosize={{ minRows: 2, maxRows: 100}} placeholder="请输入内容" />
        </div>

        <div style={{display: 'flex', justifyContent: 'center', alignItems: 'center', margin: '2rem'}}>
          <Button type="primary" >主要按钮</Button>
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

export default Fill
