import { WebPlugin } from '@capacitor/core';

import type { UdpRequestsPlugin } from './definitions';

export class UdpRequestsWeb extends WebPlugin implements UdpRequestsPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
