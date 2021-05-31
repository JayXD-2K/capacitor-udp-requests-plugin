export interface UdpRequestsPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
