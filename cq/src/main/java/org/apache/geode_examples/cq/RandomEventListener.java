// Copyright (c) VMware, Inc. 2023.
// All rights reserved. SPDX-License-Identifier: Apache-2.0

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.apache.geode_examples.cq;

import org.apache.geode.cache.Operation;
import org.apache.geode.cache.query.CqEvent;
import org.apache.geode.cache.query.CqListener;

public class RandomEventListener implements CqListener {

  @Override
  public void onEvent(CqEvent cqEvent) {

    Operation queryOperation = cqEvent.getQueryOperation();


    if (queryOperation.isUpdate()) {
      System.out.print("-------Updated Value\n");
    } else if (queryOperation.isCreate()) {
      System.out.print("-------Value Created\n");
    }
  }

  @Override
  public void onError(CqEvent cqEvent) {
    System.out.print("**Something bad happened**");
  }

  @Override
  public void close() {

  }

}
