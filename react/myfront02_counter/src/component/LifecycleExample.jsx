import React from 'react';

// ** Lifecycle Test
// 1. 생성
// => App 실행, 호출
//    생성시작 - constructor - componentDidMount -> 생성완료

// 2. 변경 Test
// => test1) shouldComponentUpdate() : return false 추가 비교
// => test2) shouldComponentUpdate() : return false 추가 후
//           componentDidMount() :  1), 2) 비교

// constructor
// => 컴포넌트의 생성자 메서드로, 컴포넌트가 만들어질 때 처음으로 실행
// getDerivedStateFromProps
// => props로부터 상태를 동기화하는 메서드로, 컴포넌트가 마운트될 때와 업데이트될 때 호출
// componentDidMount
// => 컴포넌트가 DOM에 마운트된 직후에 호출되는 메서드로, 초기 데이터 로딩이나 외부 리소스 요청 등의 작업을 수행
// componentDidUpdate
// => 컴포넌트가 업데이트된 직후에 호출되는 메서드로, 컴포넌트가 리렌더링된 후 추가적인 작업을 수행
// componentWillUnmount
// => 컴포넌트가 언마운트되기 직전에 호출되는 메서드로, 리소스 정리나 이벤트 핸들러 제거 등의 작업을 수행
// getSnapshotBeforeUpdate
// => 컴포넌트 업데이트 이전의 상태를 저장하는 메서드로, 업데이트 전에 어떤 데이터가 변경되었는지 파악하는 데 사용
// shouldComponentUpdate
// => 컴포넌트 업데이트 여부를 결정하는 메서드로, 성능 최적화에 사용됩니다.이 메서드에서 true 또는 false를 반환하여 컴포넌트의 업데이트 여부를 제어할 수 있음
// render
// => 컴포넌트의 렌더링 메서드로, JSX를 반환하여 실제로 화면에 렌더링

class LifecycleExample extends React.Component {
  // component 생성자 method
  constructor(props) {
    super(props);
    // getDerivedStateFromProps를 사용하기 때문에`
    // 경고 메세지를 건너뛰기위해 초기 상태를 설정합니다.
    this.state = {};
    console.log('constructor 호출');
  }

  // props로부터 상태 동기화 method
  static getDerivedStateFromProps() {
    console.log('getDerivedStateFromProps 호출');
    return {};
  }

  // 컴포넌트가 DOM에 마운트된 직후에 호출되는 method
  componentDidMount() {
    console.log('componentDidMount 호출');
    // => 1) , 2)  를 번갈아 추가하며 비교
    // => shouldComponentUpdate() 의 return 값과 무관하게 동기화 진행
    // this.setState({ updated: true});  // 1) 상태값 변경
    // this.forceUpdate();  // 2) 
    // => forceUpdate() method
    //    클래스형 컴포넌트에서는 공식적으로 리렌더를 강제하는 API.
    //    this.forceUpdate()를 호출하면 shouldComponentUpdate()를 건너뛰고 
    //    render() 메서드가 호출되므로 React가 가상 DOM과 DOM의 상태를 재비교하도록 강제하여 리랜더를 강제함.
  }

  // 컴포넌트가 업데이트된 직후에 호출되는 method
  componentDidUpdate() {
    console.log('componentDidUpdate 호출');
  }

  // 컴포넌트가 언마운트되기 직전에 호출되는 method
  componentWillUnmount() {
    console.log('componentWillUnmount 호출');
  }
  
  // 업데이트 이전의 상태를 저장하는 method
  getSnapshotBeforeUpdate() {
    console.log('getSnapshotBeforeUpdate 호출');
    return {};
  }

  // 컴포넌트 업데이트 여부를 결정하는 method
  shouldComponentUpdate() {
    console.log('shouldComponentUpdate 호출');
    // 강제로 false를 return 해본다.
    // return false;
  }

  // 렌더링 method
  render() {
    console.log('render 호출');
    return null;
  }
}

export default LifecycleExample;
